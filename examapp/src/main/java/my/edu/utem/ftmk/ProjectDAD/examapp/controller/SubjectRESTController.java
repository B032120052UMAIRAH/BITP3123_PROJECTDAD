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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Subject;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.SubjectRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/subjects")
public class SubjectRESTController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping
	public List<Subject> getSubjects()
	{
		return subjectRepository.findAll();
		
	}
	
	//retrieve subject details
	@GetMapping("{subject_code}")
	public Subject getSubject(@PathVariable String subject_code)
	{
		Subject subject  = subjectRepository.findById(subject_code).get();
		
		return subject;
	}
	
	//insert subject 
	@PostMapping
	public Subject insertSubject(@RequestBody Subject subject)
	{
		return subjectRepository.save(subject);
	}
	
	//update subject 
	@PutMapping
	public Subject updateSubject(@RequestBody Subject subject)
	{
		return subjectRepository.save(subject);
	}
	
	//delete subject by ID as subject_code 
	@DeleteMapping("{subject_code}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable String subject_code)
	{
		subjectRepository.deleteById(subject_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
