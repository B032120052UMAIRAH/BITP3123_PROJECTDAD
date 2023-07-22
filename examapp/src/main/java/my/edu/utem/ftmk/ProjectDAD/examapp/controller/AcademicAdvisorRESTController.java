package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.AcademicAdvisor;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.AcademicAdvisorRepository;


/**
 * @author user
 *
 */
@RestController
@RequestMapping("/api/academicadvisors")
public class AcademicAdvisorRESTController {
	
	@Autowired
	private AcademicAdvisorRepository academicAdvisorRepository;
	/*
	 * Find all academic advisor
	 */	
	@GetMapping
	public List<AcademicAdvisor> getAcademicAdvisors(){
		return academicAdvisorRepository.findAll();
	}
	
	/**
	 * Retrieve academic advisor details
	 * 
	 * @param advisorId
	 * @return
	 */
	@GetMapping("{advisorId}")
	public AcademicAdvisor getAcademicAdvisor(@PathVariable String advisorId){
		AcademicAdvisor academicAdvisor  = 
				academicAdvisorRepository.findById(advisorId).get();
		return academicAdvisor;
	}
	
	/**
	 * Insert academic advisor
	 * 
	 * @param academicAdvisor
	 * @return
	 */
	@PostMapping
	public AcademicAdvisor insertAcademicAdvisor(@RequestBody AcademicAdvisor academicAdvisor){
		return academicAdvisorRepository.save(academicAdvisor);
	}
	
	/**
	 * Update academic advisor
	 * 
	 * @param academicAdvisor
	 * @return
	 */
	@PutMapping
	public AcademicAdvisor updateAcademicAdvisor(@RequestBody AcademicAdvisor academicAdvisor){
		return academicAdvisorRepository.save(academicAdvisor);
	}
	
	/**
	 * Delete academic advisor
	 * 
	 * @param advisorId
	 * @return
	 */
	@DeleteMapping("{advisorId}")
	public ResponseEntity<HttpStatus> deleteAcademicAdvisor(@PathVariable String advisorId){
		academicAdvisorRepository.deleteById(advisorId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
