package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Examination;

/**
 * This Menu Controller Class for List Examination
 * 
 * @author Imran
 */

@Controller
public class ExaminationMenuController {
	
	
	/**
	 * The method is annotated with @GetMapping("/exam/list"), 
	 * indicating that it handles GET requests to the "/exam/list" 
	 * endpoint.
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/exam/list")
	public String getExamination(Model model){
		
		// URI get examination
		String uri ="http://localhost:8080/examapp/api/examinations";
		
		// get list examination from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Examination[]> response = 
				restTemplate.getForEntity(uri, Examination[].class);
		
		// Parse JSON data to array of object
		Examination exams[]=response.getBody();

		// Parse array to a list object
		List<Examination> examList = Arrays.asList(exams);
		
		// Attach list to model as attribute
		model.addAttribute("exams",examList);
		
		return "exams";
	}
}
