package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Examination;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.ExaminationRepository;


@RestController
@RequestMapping("/api/examinations")
public class ExaminationRESTController {

	@Autowired
	private ExaminationRepository examRepository;
	
	@GetMapping
	public List<Examination> getExams()
	{
		return examRepository.findAll();
		
	}
	
	//retrieve exam schedule details
	@GetMapping("{exam_code}")
	public Examination getExam(@PathVariable long exam_code)
	{
		Examination exam  = examRepository.findById(exam_code).get();
		
		return exam;
	}
	
	//insert exam
	@PostMapping
	public Examination insertExam(@RequestBody Examination exam)
	{
		return examRepository.save(exam);
	}
	
	//update exam

	@PutMapping
	public Examination updateExam(@RequestBody Examination exam)
	{
		return examRepository.save(exam);
	}
	
	//delete exam
	@DeleteMapping("{exam_code}")
	public ResponseEntity<HttpStatus> deleteExamSchedule(@PathVariable long exam_code)
	{
		examRepository.deleteById(exam_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
