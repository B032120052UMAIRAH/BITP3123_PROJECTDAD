package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "matricno")
	private String matricno;
	
	@Column(name = "student_name")
	private String student_name;
	
	@Column(name = "student_email")
	private String student_email;
	
	@Column(name = "student_phoneNumber")
	private int student_phoneNumber;
	
	@Column(name = "advisor_ID")
	private String advisor_ID;
	
	@Column(name = "faculty_code")
	private String faculty_code;
	
	@Column(name = "course_code")
	private String course_code;

	public String getMatricno() {
		return matricno;
	}

	public void setMatricno(String matricno) {
		this.matricno = matricno;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public int getStudent_phoneNumber() {
		return student_phoneNumber;
	}

	public void setStudent_phoneNumber(int student_phoneNumber) {
		this.student_phoneNumber = student_phoneNumber;
	}

	public String getAdvisor_ID() {
		return advisor_ID;
	}

	public void setAdvisor_ID(String advisor_ID) {
		this.advisor_ID = advisor_ID;
	}

	public String getFaculty_code() {
		return faculty_code;
	}

	public void setFaculty_code(String faculty_code) {
		this.faculty_code = faculty_code;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	
	
	
	
}
