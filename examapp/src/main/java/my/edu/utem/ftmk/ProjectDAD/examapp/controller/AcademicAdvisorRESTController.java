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

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
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
	public List<AcademicAdvisor> getAcademicAdvisors()
	{
		return academicAdvisorRepository.findAll();
		
	}
	
	//retrieve academic advisor details
	@GetMapping("{advisor_ID}")
	public AcademicAdvisor getAcademicAdvisor(@PathVariable String advisor_ID)
	{
		AcademicAdvisor academicAdvisor  = academicAdvisorRepository.findById(advisor_ID).get();
		
		return academicAdvisor;
	}
	
	//insert academic advisor
	@PostMapping
	public AcademicAdvisor insertAcademicAdvisor(@RequestBody AcademicAdvisor academicAdvisor)
	{
		return academicAdvisorRepository.save(academicAdvisor);
	}
	
	//update academic advisor
	@PutMapping
	public AcademicAdvisor updateAcademicAdvisor(@RequestBody AcademicAdvisor academicAdvisor)
	{
		return academicAdvisorRepository.save(academicAdvisor);
	}
	
	//delete academic advisor
	@DeleteMapping("{advisor_ID}")
	public ResponseEntity<HttpStatus> deleteAcademicAdvisor(@PathVariable String advisor_ID)
	{
		academicAdvisorRepository.deleteById(advisor_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
