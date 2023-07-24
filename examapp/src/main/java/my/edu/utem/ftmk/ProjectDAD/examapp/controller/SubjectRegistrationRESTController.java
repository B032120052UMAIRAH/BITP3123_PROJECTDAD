package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.SubjectRegistration;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.SubjectRegistrationRepository;


/**
 * This REST Controller Class for Subject Registration 
 * 
 * @author Umairah  
 *
 */
@RestController
@RequestMapping("/api/subjectregistrations")
public class SubjectRegistrationRESTController {
	
	@Autowired
	private SubjectRegistrationRepository subjectRegistrationRepository;
	/*
	 * Find all subject registration 
	 */
	@GetMapping
	public List<SubjectRegistration> getSubjectRegistrations(){
		return subjectRegistrationRepository.findAll();
	}
	
	/**
	 * Retrieve subject registration details
	 * 
	 * @param subjRegId
	 * @return
	 */
	@GetMapping("{subjRegId}")
	public SubjectRegistration getAttendance(@PathVariable long subjRegId){
		SubjectRegistration subjectRegistration  = 
				subjectRegistrationRepository.findById(subjRegId).get();
		
		return subjectRegistration;
	}
	
	
	/**
	 * Insert subject registration details
	 * 
	 * @param subjectRegistration
	 * @return
	 */
	@PostMapping
	public SubjectRegistration insertSubjectRegistration
	(@RequestBody SubjectRegistration subjectRegistration){
		
		return subjectRegistrationRepository.save(subjectRegistration);
	}
	
	/**
	 * Update subject registration details
	 * 
	 * @param subjectRegistration
	 * @return
	 */
	@PutMapping
	public SubjectRegistration updateSubjectRegistration
	(@RequestBody SubjectRegistration subjectRegistration){
		
		return subjectRegistrationRepository.save(subjectRegistration);
	}
	
	/**
	 * Delete subject registration details
	 * 
	 * @param subjRegId
	 * @return
	 */
	@DeleteMapping("{subjRegId}")
	public ResponseEntity<HttpStatus> deleteSubjectRegistration
	(@PathVariable long subjRegId){
		
		subjectRegistrationRepository.deleteById(subjRegId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
