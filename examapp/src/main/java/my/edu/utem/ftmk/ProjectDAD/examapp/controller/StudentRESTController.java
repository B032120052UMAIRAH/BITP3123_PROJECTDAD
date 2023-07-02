package my.edu.utem.ftmk.ProjectDAD.examapp.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import my.edu.utem.ftmk.ProjectDAD.examapp.model.Student;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.StudentRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/students")
public class StudentRESTController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> getStudents()
	{
		return studentRepository.findAll();
		
	}
	
	//retrieve order details by matric number (matricno)
	@GetMapping("{matricno}")
	public Student getStudent(@PathVariable String matricno)
	{
		Student student  = studentRepository.findById(matricno).get();
		return student;
	}
	
	//insert student details 
	@PostMapping
	public Student insertStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	//update student details
	@PutMapping
	public Student updateStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	//delete student by matric number as id (matricno)
	@DeleteMapping("{matricno}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String matricno)
	{
		studentRepository.deleteById(matricno);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
