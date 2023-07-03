package my.edu.utem.ftmk.ProjectDAD.examapp.controller;
import java.util.List;
import java.util.Arrays;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Student;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

/**
 * This Menu Controller Class for List Student
 * 
 * @author Imran
 *
 */

@Controller
public class StudentMenuController {
	
	@GetMapping("/student/list")
	public String getStudents(Model model){
		
		//URI get order types
		String uri ="http://localhost:8080/examapp/api/students";
		
		//get list order types from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(uri, Student[].class);
		
		//Parse JSON data to array of object
		Student students[]=response.getBody();

		//Parse array to a list object
		List<Student> studentList = Arrays.asList(students);
		
		//Attach list to model as attribute
		model.addAttribute("students",studentList);
		
		return "students";
	}

}
