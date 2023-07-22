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
 * @author user
 *
 */
@RestController
@RequestMapping("/api/studentattendances")
public class StudentAttendanceRESTController {
	
	@Autowired
	private StudentAttendanceRepository studentAttendanceRepository;
	
	@GetMapping
	public List<StudentAttendance> getStudentAttendances(){
		return studentAttendanceRepository.findAll();
		
	}
	
	// retrieve student attendance details
	@GetMapping("{attendanceId}")
	public StudentAttendance getStudentAttendance(@PathVariable long attendanceId){
		StudentAttendance studentAttendance  = studentAttendanceRepository.
				findById(attendanceId).get();
		return studentAttendance;
	}

	// insert student Attendance
	@PostMapping
	public StudentAttendance insertStudentAttendance
	(@RequestBody StudentAttendance studentAttendance){
		
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	// update student Attendance
	@PutMapping
	public StudentAttendance updateStudentAttendance
	(@RequestBody StudentAttendance studentAttendance){
		
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	// delete student Attendance
	@DeleteMapping("{attendanceId}")
	public ResponseEntity<HttpStatus> deleteStudentAttendance
	(@PathVariable long attendanceId){
		
		studentAttendanceRepository.deleteById(attendanceId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// retrieve student attendance details
	@GetMapping("/absents")
	public List<StudentAttendance> getAttendAbsent(){
		return studentAttendanceRepository.selectCustomByCode();
	}
	
	// retrieve student attendance details
	@GetMapping("/presents")
	public List<StudentAttendance> getAttendPresents(){
		return studentAttendanceRepository.selectCustomByCodePresent();
	}

	

}
