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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Lecturer;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.LecturerRepository;

/**
 * This REST Controller Class for Lecturer
 * 
 * @author Imran 
 *
 */
@RestController
@RequestMapping("/api/lecturers")
public class LecturerRESTController {

	@Autowired
	private LecturerRepository lecturerRepository;
	/*
	 * Find all lecturer
	 */
	@GetMapping
	public List<Lecturer> getLecturers(){
		return lecturerRepository.findAll();
		
	}
	
	
	/**
	 * Retrieve lecturer details
	 * 
	 * @param lecturerId
	 * @return
	 */
	@GetMapping("{lecturerId}")
	public Lecturer getLecturer(@PathVariable String lecturerId){
		Lecturer lecturer  = lecturerRepository.findById(lecturerId).get();
		return lecturer;
	}
	

	/**
	 * Insert lecturer details
	 * 
	 * @param lecturer
	 * @return
	 */
	@PostMapping
	public Lecturer insertLecturer(@RequestBody Lecturer lecturer)
	{
		return lecturerRepository.save(lecturer);
	}
	
	/**
	 * Update lecturer details
	 * 
	 * @param lecturer
	 * @return
	 */
	@PutMapping
	public Lecturer updateLecturer(@RequestBody Lecturer lecturer){
		return lecturerRepository.save(lecturer);
	}
	
	/**
	 * Delete lecturer details
	 * 
	 * @param lecturerId
	 * @return
	 */
	@DeleteMapping("{lecturerId}")
	public ResponseEntity<HttpStatus> deleteLecturer(@PathVariable String lecturerId){
		lecturerRepository.deleteById(lecturerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
