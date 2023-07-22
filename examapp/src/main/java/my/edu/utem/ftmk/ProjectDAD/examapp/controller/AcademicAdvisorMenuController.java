package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.AcademicAdvisor;

/**
 * This Menu Controller Class for List Academic Advisor
 * 
 * @author Syazwina 
 *
 */
@Controller
public class AcademicAdvisorMenuController {
	
	
	/**
	 * 	The method is annotated with @GetMapping("/academicadvisor/list"), 
	 * indicating that it handles GET requests to the "/academicadvisor/list" 
	 * endpoint.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/academicadvisor/list")
	public String getAcademicAdvisors(Model model){
		
		// URI get academic advisor
		String uri ="http://localhost:8080/examapp/api/academicadvisors";
		
		// Get list academic advisor from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AcademicAdvisor[]> response = 
				restTemplate.getForEntity(uri, AcademicAdvisor[].class);
		
		// Parse JSON data to array of object
		AcademicAdvisor academicadvisors[]=response.getBody();

		// Parse array to a list object
		List<AcademicAdvisor> academicadvisorList = Arrays.asList(academicadvisors);
		
		// Attach list to model as attribute
		model.addAttribute("academicadvisors",academicadvisorList);
		
		return "academicadvisors";
	}
}
