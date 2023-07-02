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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.ExamSchedule;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.ExamScheduleRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/examschedules")
public class ExamScheduleRESTController {

	@Autowired
	private ExamScheduleRepository examScheduleRepository;
	
	@GetMapping
	public List<ExamSchedule> getExamSchedules()
	{
		return examScheduleRepository.findAll();
		
	}
	
	//retrieve exam schedule details
	@GetMapping("{exam_code}")
	public ExamSchedule getExamSchedule(@PathVariable String exam_code)
	{
		ExamSchedule examSchedule  = examScheduleRepository.findById(exam_code).get();
		
		return examSchedule;
	}
	
	//insert exam
	@PostMapping
	public ExamSchedule insertExamSchedule(@RequestBody ExamSchedule examSchedule)
	{
		return examScheduleRepository.save(examSchedule);
	}
	
	//update exam

	@PutMapping
	public ExamSchedule updateExamSchedule(@RequestBody ExamSchedule examSchedule)
	{
		return examScheduleRepository.save(examSchedule);
	}
	
	//delete exam
	@DeleteMapping("{exam_code}")
	public ResponseEntity<HttpStatus> deleteExamSchedule(@PathVariable String exam_code)
	{
		examScheduleRepository.deleteById(exam_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
