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

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/facultys")
public class FacultyRESTController {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@GetMapping
	public List<Faculty> getFacultys()
	{
		return facultyRepository.findAll();
		
	}
	
	//retrieve faculty details
	@GetMapping("{faculty_code}")
	public Faculty getFaculty(@PathVariable String faculty_code)
	{
		Faculty faculty  = facultyRepository.findById(faculty_code).get();
		
		return faculty;
	}
	//insert faculty
	@PostMapping
	public Faculty insertFaculty(@RequestBody Faculty faculty)
	{
		return facultyRepository.save(faculty);
	}
	
	//update faculty 
	@PutMapping
	public Faculty updateFaculty(@RequestBody Faculty faculty)
	{
		return facultyRepository.save(faculty);
	}
	
	//delete faculty using ID (faculty code)
	@DeleteMapping("{faculty_code}")
	public ResponseEntity<HttpStatus> deleteFaculty(@PathVariable String faculty_code)
	{
		facultyRepository.deleteById(faculty_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
