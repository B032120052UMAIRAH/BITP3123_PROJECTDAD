package my.edu.utem.ftmk.ProjectDAD.examapp.model;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author user
 *
 */
@Entity
@Table(name = "student_attendance")
public class StudentAttendance {

	//auto increment for new data
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "attendanceId")
	private int attendanceId;
	// attendanceId
	
	//FK for TABLE Student 
	//join the student attendance table and student table
	@ManyToOne
    @JoinColumn(name="matricNo")
	private Student matricNo;
	// matricNo
	
	@Column(name = "dateTime")
	private String dateTime;
	
	//FK for TABLE EXAMINATION 
	//join the student attendance table and examination table
	@ManyToOne
    @JoinColumn(name="examCode")
	private Examination examCode;
	// private Examination exam
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "status")
	private String status;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Student getMatricNo() {
		return matricNo;
	}

	public void setMatricNo(Student matricNo) {
		this.matricNo = matricNo;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Examination getExamCode() {
		return examCode;
	}

	public void setExamCode(Examination examCode) {
		this.examCode = examCode;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
