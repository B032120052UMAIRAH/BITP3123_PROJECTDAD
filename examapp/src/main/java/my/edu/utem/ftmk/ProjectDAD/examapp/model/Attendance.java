package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * This model class to provoke set and get attribute 
 * for table  Attendance
 * 
 * @author Group 18
 *
 */
@Entity
@Table(name = "attendance")
public class Attendance {

	@Id
	@Column(name = "attendance_ID")
	private String attendance_ID;
	
	@Column(name = "method")
	private String method;

	public String getAttendance_ID() {
		return attendance_ID;
	}

	public void setAttendance_ID(String attendance_ID) {
		this.attendance_ID = attendance_ID;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
}
