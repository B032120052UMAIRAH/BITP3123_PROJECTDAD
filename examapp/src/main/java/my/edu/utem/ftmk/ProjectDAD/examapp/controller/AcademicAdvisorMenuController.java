package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.AcademicAdvisor;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@Controller
public class AcademicAdvisorMenuController {

	@GetMapping("/academicadvisor/list")
	public String getAcademicAdvisors(Model model){
		
		//URI get order types
		String uri ="http://localhost:8080/examapp/api/academicadvisors";
		
		//get list order types from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AcademicAdvisor[]> response = 
				restTemplate.getForEntity(uri, AcademicAdvisor[].class);
		
		//Parse JSON data to array of object
		AcademicAdvisor academicadvisors[]=response.getBody();

		//Parse array to a list object
		List<AcademicAdvisor> academicadvisorList = Arrays.asList(academicadvisors);
		
		//Attach list to model as attribute
		model.addAttribute("academicadvisors",academicadvisorList);
		
		return "academicadvisors";
	}
}
