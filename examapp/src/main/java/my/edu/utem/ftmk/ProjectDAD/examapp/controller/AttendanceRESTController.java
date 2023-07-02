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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Attendance;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.AttendanceRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/attendances")
public class AttendanceRESTController {

	@Autowired
	private AttendanceRepository attendanceRepository;
	

	@GetMapping
	public List<Attendance> getAttendances()
	{
		return attendanceRepository.findAll();
		
	}
	
	//retrieve attendance details
	@GetMapping("{attendance_ID}")
	public Attendance getAttendance(@PathVariable String attendance_ID)
	{
		Attendance attendance  = attendanceRepository.findById(attendance_ID).get();
		
		return attendance;
	}
	
	//insert attendance
	@PostMapping
	public Attendance insertAttendance(@RequestBody Attendance attendance)
	{
		return attendanceRepository.save(attendance);
	}
	
	//update attendance

	@PutMapping
	public Attendance updateAttendance(@RequestBody Attendance attendance)
	{
		return attendanceRepository.save(attendance);
	}
	
	//delete attendance
	@DeleteMapping("{attendance_ID}")
	public ResponseEntity<HttpStatus> deleteAttendance(@PathVariable String attendance_ID)
	{
		attendanceRepository.deleteById(attendance_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
