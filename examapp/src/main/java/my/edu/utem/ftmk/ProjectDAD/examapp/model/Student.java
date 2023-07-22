package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author user
 *
 */
@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "matricNo")
	private String matricNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	//FK for academic advisor  
	//join the subject student table and academic advisor table
	@ManyToOne
    @JoinColumn(name="advisorId")
	private AcademicAdvisor advisorId;
	
	//FK for faculty  
	//join the subject student table and faculty table
	@ManyToOne
	@JoinColumn(name = "facultyCode")
	private Faculty facultyCode;
	
	//FK for course  
	//join the subject student table and course table
	@ManyToOne
	@JoinColumn(name = "courseCode")
	private Course courseCode;

	public String getMatricNo() {
		return matricNo;
	}

	public void setMatricNo(String matricNo) {
		this.matricNo = matricNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AcademicAdvisor getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(AcademicAdvisor advisorId) {
		this.advisorId = advisorId;
	}

	public Faculty getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(Faculty facultyCode) {
		this.facultyCode = facultyCode;
	}

	public Course getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Course courseCode) {
		this.courseCode = courseCode;
	}


}
