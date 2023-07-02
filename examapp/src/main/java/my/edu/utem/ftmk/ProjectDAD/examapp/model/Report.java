package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report")
public class Report {

	@Id
	@Column(name = "report_ID")
	private int report_ID;
	
	@Column(name = "total_student_absent")
	private int total_student_absent;
	
	@Column(name = "total_student_present")
	private int total_student_present;
	
	@Column(name = "attendance_ID")
	private String attendance_ID;
	
	@Column(name = "exam_code")
	private String exam_code;

	public int getReport_ID() {
		return report_ID;
	}

	public void setReport_ID(int report_ID) {
		this.report_ID = report_ID;
	}

	public int getTotal_student_absent() {
		return total_student_absent;
	}

	public void setTotal_student_absent(int total_student_absent) {
		this.total_student_absent = total_student_absent;
	}

	public int getTotal_student_present() {
		return total_student_present;
	}

	public void setTotal_student_present(int total_student_present) {
		this.total_student_present = total_student_present;
	}

	public String getAttendance_ID() {
		return attendance_ID;
	}

	public void setAttendance_ID(String attendance_ID) {
		this.attendance_ID = attendance_ID;
	}

	public String getExam_code() {
		return exam_code;
	}

	public void setExam_code(String exam_code) {
		this.exam_code = exam_code;
	}
	
	
	
	
}
