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
 * @author user
 *
 */
@RestController
@RequestMapping("/api/lecturers")
public class LecturerRESTController {

	@Autowired
	private LecturerRepository lecturerRepository;
	
	@GetMapping
	public List<Lecturer> getLecturers(){
		return lecturerRepository.findAll();
		
	}
	
	// retrieve lecturer details
	@GetMapping("{lecturerId}")
	public Lecturer getLecturer(@PathVariable String lecturerId){
		Lecturer lecturer  = lecturerRepository.findById(lecturerId).get();
		return lecturer;
	}
	
	// insert lecturer
	@PostMapping
	public Lecturer insertLecturer(@RequestBody Lecturer lecturer)
	{
		return lecturerRepository.save(lecturer);
	}
	
	// update lecturer
	@PutMapping
	public Lecturer updateLecturer(@RequestBody Lecturer lecturer){
		return lecturerRepository.save(lecturer);
	}
	
	// delete lecturer
	@DeleteMapping("{lecturerId}")
	public ResponseEntity<HttpStatus> deleteLecturer(@PathVariable String lecturerId){
		lecturerRepository.deleteById(lecturerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
