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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Course;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.CourseRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/courses")
public class CourseRESTController {

	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<Course> getCourses()
	{
		return courseRepository.findAll();
		
	}
	
	//retrieve course details
	@GetMapping("{course_code}")
	public Course getCourse(@PathVariable String course_code)
	{
		Course course  = courseRepository.findById(course_code).get();
		
		return course;
	}
	//insert Course
	@PostMapping
	public Course insertCourse(@RequestBody Course course)
	{
		return courseRepository.save(course);
	}
	
	//update Course
	@PutMapping
	public Course updateCourse(@RequestBody Course course)
	{
		return courseRepository.save(course);
	}
	
	//delete Course
	@DeleteMapping("{course_code}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String course_code)
	{
		courseRepository.deleteById(course_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
