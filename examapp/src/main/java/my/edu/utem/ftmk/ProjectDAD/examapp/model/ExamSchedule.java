package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class to provoke set and get attribute 
 * for table Exam Schedule
 * 
 * @author Group 18
 *
 */

@Entity
@Table(name = "exam_schedule")
public class ExamSchedule {

	@Id
	@Column(name = "exam_code")
	private String exam_code;
	
	@Column(name = "matricno")
	private String matricno;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;

	public String getExam_code() {
		return exam_code;
	}

	public void setExam_code(String exam_code) {
		this.exam_code = exam_code;
	}

	public String getMatricno() {
		return matricno;
	}

	public void setMatricno(String matricno) {
		this.matricno = matricno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
