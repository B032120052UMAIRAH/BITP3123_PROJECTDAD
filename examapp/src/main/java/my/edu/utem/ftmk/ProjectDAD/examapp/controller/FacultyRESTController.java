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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Faculty;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.FacultyRepository;


/**
 * This REST Controller Class for Faculty
 * 
 * @author Imran 
 *
 */
@RestController
@RequestMapping("/api/faculties")
public class FacultyRESTController {

	@Autowired
	private FacultyRepository facultyRepository;
	/*
	 * Find all faculty
	 */
	@GetMapping
	public List<Faculty> getFacultys(){
		return facultyRepository.findAll();
	}
	
	/**
	 * Retrieve faculty details
	 * 
	 * @param facultyCode
	 * @return
	 */
	@GetMapping("{facultyCode}")
	public Faculty getFaculty(@PathVariable String facultyCode){
		Faculty faculty  = facultyRepository.findById(facultyCode).get();
		return faculty;
	}
	
	/**
	 * Insert faculty details
	 * 
	 * @param faculty
	 * @return
	 */
	@PostMapping
	public Faculty insertFaculty(@RequestBody Faculty faculty){
		return facultyRepository.save(faculty);
	}
	
	/**
	 * Update faculty details
	 * 
	 * @param faculty
	 * @return
	 */
	@PutMapping
	public Faculty updateFaculty(@RequestBody Faculty faculty){
		return facultyRepository.save(faculty);
	}
	
	
	/**
	 * Delete faculty details
	 * 
	 * @param facultyCode
	 * @return
	 */
	@DeleteMapping("{facultyCode}")
	public ResponseEntity<HttpStatus> deleteFaculty(@PathVariable String facultyCode){
		facultyRepository.deleteById(facultyCode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
