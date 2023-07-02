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


/*CREATE BY GROUP 18
 * B032120052 - Umairah
 * B032120025 - Imran
 * B032120040 - Syazwina
*/

@RestController
@RequestMapping("/api/subjectregistrations")
public class SubjectRegistrationRESTController {
	
	@Autowired
	private SubjectRegistrationRepository subjectRegistrationRepository;
	

	@GetMapping
	public List<SubjectRegistration> getSubjectRegistrations()
	{
		return subjectRegistrationRepository.findAll();
		
	}
	
	//retrieve attendance details
	@GetMapping("{subjReg_ID}")
	public SubjectRegistration getAttendance(@PathVariable long subjReg_ID)
	{
		SubjectRegistration subjectRegistration  = subjectRegistrationRepository.findById(subjReg_ID).get();
		
		return subjectRegistration;
	}
	
	//insert attendance
	@PostMapping
	public SubjectRegistration insertSubjectRegistration(@RequestBody SubjectRegistration subjectRegistration)
	{
		return subjectRegistrationRepository.save(subjectRegistration);
	}
	
	//update attendance

	@PutMapping
	public SubjectRegistration updateSubjectRegistration(@RequestBody SubjectRegistration subjectRegistration)
	{
		return subjectRegistrationRepository.save(subjectRegistration);
	}
	
	//delete attendance
	@DeleteMapping("{subjReg_ID}")
	public ResponseEntity<HttpStatus> deleteSubjectRegistration(@PathVariable long subjReg_ID)
	{
		subjectRegistrationRepository.deleteById(subjReg_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
