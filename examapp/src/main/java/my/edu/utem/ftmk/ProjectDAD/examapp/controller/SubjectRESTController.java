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

/**
 * This REST Controller Class for Subject
 * 
 * @author Syazwina 
 *
 */
@RestController
@RequestMapping("/api/subjects")
public class SubjectRESTController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	/*
	 * Find all subject  
	 */
	@GetMapping
	public List<Subject> getSubjects(){
		return subjectRepository.findAll();
	}
	
	/**
	 * Retrieve subject details
	 * 
	 * @param subjectCode
	 * @return
	 */
	@GetMapping("{subjectCode}")
	public Subject getSubject(@PathVariable String subjectCode){
		Subject subject  = subjectRepository.findById(subjectCode).get();
		return subject;
	}
	
	/**
	 * Insert subject details
	 * 
	 * @param subject
	 * @return
	 */
	@PostMapping
	public Subject insertSubject(@RequestBody Subject subject){
		return subjectRepository.save(subject);
	}
	
	/**
	 * Update subject details
	 * 
	 * @param subject
	 * @return
	 */
	@PutMapping
	public Subject updateSubject(@RequestBody Subject subject){
		return subjectRepository.save(subject);
	}
	
	/**
	 * Delete subject details
	 * 
	 * @param subjectCode
	 * @return
	 */
	@DeleteMapping("{subjectCode}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable String subjectCode){
		subjectRepository.deleteById(subjectCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
