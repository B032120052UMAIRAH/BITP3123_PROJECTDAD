package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.StudentAttendance;
/**
 * This Menu Controller Class for Student Attendance
 * 
 * @author Umairah(B032120052)
 *
 */
@Controller
public class StudentAttendanceMenuController {
	
	//private String defaultURI = "http://localhost:8080/examapp/api/studentattendances";

	//LIST STUDENT ATTENDANCE
	@GetMapping("/studentattendance/list")
	public String getStudentAttendances(Model model){
		
		//URI get order types
		String uri1 ="http://localhost:8080/examapp/api/studentattendances";
		
		//get list order types from web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<StudentAttendance[]> response = 
				restTemplate.getForEntity(uri1, StudentAttendance[].class);
		
		//Parse JSON data to array of object
		StudentAttendance studentAttendances[]=response.getBody();

		//Parse array to a list object
		List<StudentAttendance> studentAttendancesList = Arrays.asList(studentAttendances);
		
		//URI get student attendances
		String uri2 ="http://localhost:8080/examapp/api/studentattendances/absents";
		//get list order types from web service
		RestTemplate restTemplateAbsent = new RestTemplate();
		ResponseEntity<StudentAttendance[]> responseAbsent = 
				restTemplateAbsent.getForEntity(uri2, StudentAttendance[].class);
				
		//Parse JSON data to array of object
		StudentAttendance studentAttendancesAbsent[]=responseAbsent.getBody();

		//Parse array to a list object
     	List<StudentAttendance> studentAttendancesAbsentList = Arrays.asList(studentAttendancesAbsent);
		
     	//URI get student attendances
     	String uri3 ="http://localhost:8080/examapp/api/studentattendances/presents";
     			
     	//get list student attendances from web service
     	RestTemplate restTemplatePresent = new RestTemplate();
     	ResponseEntity<StudentAttendance[]> responsePresent = 
     			restTemplatePresent.getForEntity(uri3, StudentAttendance[].class);
     			
     	//Parse JSON data to array of object
     	StudentAttendance studentAttendancesPresent[]=responsePresent.getBody();

     	//Parse array to a list object
     	List<StudentAttendance> studentAttendancesPresentList = Arrays.asList(studentAttendancesPresent);
     			
		//Attach list to model as attribute
		model.addAttribute("studentAttendances",studentAttendancesList);

		model.addAttribute("studentAttendancesAbsent",studentAttendancesAbsentList);
		
		model.addAttribute("studentAttendancesPresent",studentAttendancesPresentList);
		return "studentattendances";
	}
	
	/**
	 * This method will update or add an student attendances
	 * @param Student Attendance
	 * @return
	 */
	@RequestMapping("/studentattendance/save")
	public String updateStudentAttendance(@ModelAttribute StudentAttendance studentAttendance) {
		//Create new RestTmplate
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request Body
		HttpEntity<StudentAttendance> request = new HttpEntity<StudentAttendance>(studentAttendance);
		
		String studentAttendanceResponse ="";
		
		if(studentAttendance.getAttendance_ID()>0) {
			//block update an new student attendances
			//send req as PUT
			restTemplate.put("http://localhost:8080/examapp/api/studentattendances", request, StudentAttendance.class);
			
		}else {
			//block add an new student attendances
			//send req as PUT

			studentAttendanceResponse = restTemplate.postForObject("http://localhost:8080/examapp/api/studentattendances", request, String.class);
		}
		System.out.println(studentAttendanceResponse);
		
		//redirect req to display a list student attendances
		return "redirect:/studentattendance/list";
		
	}
	
	/**
	 * This method gets an attendance ID
	 * @param attendance_ID
	 * @param model
	 * @return
	 */
	@GetMapping("/studentattendance/{attendance_ID}")
	public String getAttedance(@PathVariable Integer attendance_ID, Model model) {
		String pageTitle ="New Student Attendance";
		StudentAttendance studentAttendance = new StudentAttendance();
		
		//this block get an order type to be updated
		if(attendance_ID>0) {
			
			//generate new URI and append attendance_ID to it
			String uri= "http://localhost:8080/examapp/api/studentattendances"+"/"+attendance_ID;
			
			//Get an order type form the web service
			RestTemplate restTemplate = new RestTemplate();
			studentAttendance = restTemplate.getForObject(uri,StudentAttendance.class);
			
			//give a new title to the page
			pageTitle="Edit Student Attendance";
			
			
		}
		//Attach value to pass front end
		model.addAttribute("studentAttendance",studentAttendance);
		model.addAttribute("pageTitle",pageTitle);
		
		
		return "studentattendancesinfo";
	}
	
	/**
	 * This method deletes an student attendance
	 * @param attendance_ID
	 * @return
	 */
	@RequestMapping("/studentattendance/delete/{attendance_ID}")
	public String deleteStudentAttendance(@PathVariable Integer attendance_ID) {
		
		//generate new URI,similar to the mapping in StudentAttendanceRESTController
		String uri = "http://localhost:8080/examapp/api/studentattendances" +"/{attendance_ID}";
		
		//send a delete req and attach value of attendanceID into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,Map.of("attendance_ID", Integer.toString(attendance_ID)));
		
		return "redirect:/studentattendance/list";
	}
}
