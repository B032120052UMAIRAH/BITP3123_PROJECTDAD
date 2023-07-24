package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class for Course Table 
 * 
 * @author Imran
 *
 */
@Entity
@Table(name = "course")
public class Course {
	
	//Primary Key
	@Id
	@Column(name = "courseCode")
	private String courseCode;
	
	@Column(name = "name")
	private String name;

	@Column(name = "facultyCode")
	private String facultyCode;
	// private Faculty faculty

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}
}
