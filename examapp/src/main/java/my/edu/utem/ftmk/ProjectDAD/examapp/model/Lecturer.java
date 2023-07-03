package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class to provoke set and get attribute 
 * for table Lecturer
 * 
 * @author Group 18
 *
 */

@Entity
@Table(name = "lecturer")
public class Lecturer {
	
	@Id
	@Column(name = "lecturer_ID")
	private String lecturer_ID;
	
	@Column(name = "lecturer_name")
	private String lecturer_name;
	
	@Column(name = "lecturer_department")
	private String lecturer_department;
	
	@Column(name = "lecturer_phoneNumber")
	private int lecturer_phoneNumber;
	
	@Column(name = "subject_code")
	private String subject_code;

	public String getLecturer_ID() {
		return lecturer_ID;
	}

	public void setLecturer_ID(String lecturer_ID) {
		this.lecturer_ID = lecturer_ID;
	}

	public String getLecturer_name() {
		return lecturer_name;
	}

	public void setLecturer_name(String lecturer_name) {
		this.lecturer_name = lecturer_name;
	}

	public String getLecturer_department() {
		return lecturer_department;
	}

	public void setLecturer_department(String lecturer_department) {
		this.lecturer_department = lecturer_department;
	}

	public int getLecturer_phoneNumber() {
		return lecturer_phoneNumber;
	}

	public void setLecturer_phoneNumber(int lecturer_phoneNumber) {
		this.lecturer_phoneNumber = lecturer_phoneNumber;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	
	

}
