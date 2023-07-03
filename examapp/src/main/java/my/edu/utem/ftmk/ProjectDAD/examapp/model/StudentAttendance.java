package my.edu.utem.ftmk.ProjectDAD.examapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "student_attendance")
public class StudentAttendance {

	//auto increment for new data
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "attendance_ID")
	private int attendance_ID;
	
	//FK for TABLE Student 
	//join the student attendance table and student table
	@ManyToOne
    @JoinColumn(name="matricno")
	private Student matricno;
	
	@Column(name = "dateTime")
	private String dateTime;
	
	//FK for TABLE EXAMINATION 
	//join the student attendance table and examination table
	@ManyToOne
    @JoinColumn(name="exam_code")
	private Examination exam_code;

	@Column(name = "attendance_method")
	private String attendance_method;
	
	@Column(name = "status")
	private String status;

	
//	public StudentAttendance() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public StudentAttendance(int attendance_ID, Student matricno, String dateTime, Examination exam_code,
//			String attendance_method, String status) {
//		super();
//		this.attendance_ID = attendance_ID;
//		this.matricno = matricno;
//		this.dateTime = dateTime;
//		this.exam_code = exam_code;
//		this.attendance_method = attendance_method;
//		this.status = status;
//	}


	public int getAttendance_ID() {
		return attendance_ID;
	}

	public void setAttendance_ID(int attendance_ID) {
		this.attendance_ID = attendance_ID;
	}

	public Student getMatricno() {
		return matricno;
	}

	public void setMatricno(Student matricno) {
		this.matricno = matricno;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Examination getExam_code() {
		return exam_code;
	}

	public void setExam_code(Examination exam_code) {
		this.exam_code = exam_code;
	}

	public String getAttendance_method() {
		return attendance_method;
	}

	public void setAttendance_method(String attendance_method) {
		this.attendance_method = attendance_method;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
