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

/**
 * This REST Controller Class for Student 
 * 
 * @author Imran  
 *
 */
@RestController
@RequestMapping("/api/students")
public class StudentRESTController {

	@Autowired
	private StudentRepository studentRepository;
	/*
	 * Find all student 
	 */
	@GetMapping
	public List<Student> getStudents(){
		return studentRepository.findAll();
		
	}
	
	/**
	 * Retrieve student details
	 * 
	 * @param matricNo
	 * @return
	 */
	@GetMapping("{matricNo}")
	public Student getStudent(@PathVariable String matricNo){
		Student student  = studentRepository.findById(matricNo).get();
		return student;
	}
	
	/**
	 * Insert student details
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping
	public Student insertStudent(@RequestBody Student student){
		return studentRepository.save(student);
	}
	
	/**
	 * Update student details
	 * 
	 * @param student
	 * @return
	 */
	@PutMapping
	public Student updateStudent(@RequestBody Student student){
		return studentRepository.save(student);
	}
	
	/**
	 * Delete student details
	 * 
	 * @param matricNo
	 * @return
	 */
	@DeleteMapping("{matricNo}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String matricNo){
		studentRepository.deleteById(matricNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
