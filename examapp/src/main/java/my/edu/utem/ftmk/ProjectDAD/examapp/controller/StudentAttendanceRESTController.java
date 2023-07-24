package my.edu.utem.ftmk.ProjectDAD.examapp.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.StudentAttendance;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.StudentAttendanceRepository;

/**
 * This REST Controller Class for Student Attendance
 * 
 * @author Umairah  
 *
 */
@RestController
@RequestMapping("/api/studentattendances")
public class StudentAttendanceRESTController {
	
	@Autowired
	private StudentAttendanceRepository studentAttendanceRepository;
	/*
	 * Find all student attendances
	 */
	@GetMapping
	public List<StudentAttendance> getStudentAttendances(){
		return studentAttendanceRepository.findAll();
		
	}
	
	/**
	 * Retrieve student attendance details
	 * 
	 * @param attendanceId
	 * @return
	 */
	@GetMapping("{attendanceId}")
	public StudentAttendance getStudentAttendance(@PathVariable long attendanceId){
		StudentAttendance studentAttendance  = studentAttendanceRepository.
				findById(attendanceId).get();
		return studentAttendance;
	}

	/**
	 * Insert student attendance details
	 * 
	 * @param studentAttendance
	 * @return
	 */
	@PostMapping
	public StudentAttendance insertStudentAttendance
	(@RequestBody StudentAttendance studentAttendance){
		
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	/**
	 * Update student attendance details
	 * 
	 * @param studentAttendance
	 * @return
	 */
	@PutMapping
	public StudentAttendance updateStudentAttendance
	(@RequestBody StudentAttendance studentAttendance){
		
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	/**
	 * Delete student attendance details
	 * 
	 * @param attendanceId
	 * @return
	 */
	@DeleteMapping("{attendanceId}")
	public ResponseEntity<HttpStatus> deleteStudentAttendance
	(@PathVariable long attendanceId){
		
		studentAttendanceRepository.deleteById(attendanceId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	/**
	 * Retrieve absent of student attendance details
	 * 
	 * @return
	 */
	@GetMapping("/absents")
	public List<StudentAttendance> getAttendAbsent(){
		return studentAttendanceRepository.selectCustomByCode();
	}
	
	/**
	 * Retrieve present of student attendance details
	 * 
	 * @return
	 */
	@GetMapping("/presents")
	public List<StudentAttendance> getAttendPresents(){
		return studentAttendanceRepository.selectCustomByCodePresent();
	}

	

}
