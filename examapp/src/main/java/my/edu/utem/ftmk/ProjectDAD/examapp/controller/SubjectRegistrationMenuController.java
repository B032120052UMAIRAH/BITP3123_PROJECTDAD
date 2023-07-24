package my.edu.utem.ftmk.ProjectDAD.examapp.controller;
/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.SubjectRegistration;

/**
 * This Menu Controller Class for List Subject Registration
 * 
 * @author Umairah
 *
 */
@Controller
public class SubjectRegistrationMenuController {

	/**
	 * The method is annotated with @GetMapping("/subjectregistration/list"), 
	 * indicating that it handles GET requests to the "/subjectregistration/list" 
	 * endpoint.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/subjectregistration/list")
	public String getSubjectRegistrations(Model model){
		
		// URI get subject registrations
		String uri ="http://localhost:8080/examapp/api/subjectregistrations";
		
		// get list subject registrations from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<SubjectRegistration[]> response = 
				restTemplate.getForEntity(uri, SubjectRegistration[].class);
		
		// Parse JSON data to array of object
		SubjectRegistration subjectRegistrations[]=response.getBody();

		// Parse array to a list object
		List<SubjectRegistration> subjectregistrationList = 
				Arrays.asList(subjectRegistrations);
		
		// Attach list to model as attribute
		model.addAttribute("subjectRegistrations",subjectregistrationList);
		
		return "subjectregistrations";
	}
	
}
