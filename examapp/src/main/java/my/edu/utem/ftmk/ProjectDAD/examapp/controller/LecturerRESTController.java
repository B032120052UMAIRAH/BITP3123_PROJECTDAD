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

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/lecturers")
public class LecturerRESTController {

	@Autowired
	private LecturerRepository lecturerRepository;
	
	@GetMapping
	public List<Lecturer> getLecturers()
	{
		return lecturerRepository.findAll();
		
	}
	
	//retrieve lecturer details
	@GetMapping("{lecturer_ID}")
	public Lecturer getLecturer(@PathVariable String lecturer_ID)
	{
		Lecturer lecturer  = lecturerRepository.findById(lecturer_ID).get();
		
		return lecturer;
	}
	
	//insert lecturer
	@PostMapping
	public Lecturer insertLecturer(@RequestBody Lecturer lecturer)
	{
		return lecturerRepository.save(lecturer);
	}
	
	//update lecturer
	@PutMapping
	public Lecturer updateLecturer(@RequestBody Lecturer lecturer)
	{
		return lecturerRepository.save(lecturer);
	}
	
	//delete lecturer
	@DeleteMapping("{lecturer_ID}")
	public ResponseEntity<HttpStatus> deleteLecturer(@PathVariable String lecturer_ID)
	{
		lecturerRepository.deleteById(lecturer_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
