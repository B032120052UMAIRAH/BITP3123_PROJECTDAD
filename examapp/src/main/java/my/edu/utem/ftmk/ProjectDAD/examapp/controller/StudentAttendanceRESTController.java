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

/*CREATE BY GROUP 18
 * B032120052 - Umairah
 * B032120025 - Imran
 * B032120040 - Syazwina
*/

@RestController
@RequestMapping("/api/studentattendances")
public class StudentAttendanceRESTController {
	
	@Autowired
	private StudentAttendanceRepository studentAttendanceRepository;
	
	@GetMapping
	public List<StudentAttendance> getStudentAttendances()
	{
		return studentAttendanceRepository.findAll();
		
	}
	
	//retrieve student attendance details
	@GetMapping("{attendance_ID}")
	public StudentAttendance getStudentAttendance(@PathVariable long attendance_ID)
	{
		StudentAttendance studentAttendance  = studentAttendanceRepository.findById(attendance_ID).get();
		
		return studentAttendance;
	}
	
//	//Retrieves attendance records by exam ID from the attendance repository.
//
//    @GetMapping("/studentattendances/{exam_code}")
//    public List<StudentAttendance> getAttendancesByExamCode(@PathVariable int exam_code) {
//
//        return studentAttendanceRepository.findByExaminationExamCode(exam_code);
//
//    }
//	
	//insert student Attendance
	@PostMapping
	public StudentAttendance insertStudentAttendance(@RequestBody StudentAttendance studentAttendance)
	{
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	//update student Attendance
	@PutMapping
	public StudentAttendance updateStudentAttendance(@RequestBody StudentAttendance studentAttendance)
	{
		return studentAttendanceRepository.save(studentAttendance);
	}
	
	//delete student Attendance
	@DeleteMapping("{attendance_ID}")
	public ResponseEntity<HttpStatus> deleteStudentAttendance(@PathVariable long attendance_ID)
	{
		studentAttendanceRepository.deleteById(attendance_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//retrieve student attendance details
	@GetMapping("/absents")
	public List<StudentAttendance> getAttendAbsent()
	{
		return studentAttendanceRepository.selectCustomByCode();
	}
	
	//retrieve student attendance details
	@GetMapping("/presents")
	public List<StudentAttendance> getAttendPresents()
	{
		return studentAttendanceRepository.selectCustomByCodePresent();
	}

	

}
