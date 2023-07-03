package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This model class to provoke set and get attribute 
 * for table Examination
 * 
 * @author Group 18
 *
 */

@Entity
@Table(name ="examination")
public class Examination {
	
	//auto increment for new data
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "exam_code")
	private int exam_code;
	
	@Column(name = "exam_venue")
	private String exam_venue;
	
	@Column(name = "exam_date")
	private Date exam_date;
	
	@Column(name = "exam_time")
	private LocalTime exam_time;
	
	//FK for TABLE Subject 
	//join the examination table and subject table
	@ManyToOne
    @JoinColumn(name="subject_code")
    private Subject subject_code;
	
	@Column(name = "duration")
	private int duration;
	
	//FK for TABLE Lecturer 
	//join the examination table and lecturer table
	@ManyToOne
    @JoinColumn(name="lecturer_ID")
    private Lecturer lecturer_ID;
	
	public Examination() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Examination(int exam_code, String exam_venue, Date exam_date, LocalTime exam_time, Subject subject_code,
			int duration, Lecturer lecturer_ID) {
		super();
		this.exam_code = exam_code;
		this.exam_venue = exam_venue;
		this.exam_date = exam_date;
		this.exam_time = exam_time;
		this.subject_code = subject_code;
		this.duration = duration;
		this.lecturer_ID = lecturer_ID;
	}

	public int getExam_code() {
		return exam_code;
	}

	public void setExam_code(int exam_code) {
		this.exam_code = exam_code;
	}

	public String getExam_venue() {
		return exam_venue;
	}

	public void setExam_venue(String exam_venue) {
		this.exam_venue = exam_venue;
	}

	public Date getExam_date() {
		return exam_date;
	}

	public void setExam_date(Date exam_date) {
		this.exam_date = exam_date;
	}

	public LocalTime getExam_time() {
		return exam_time;
	}

	public void setExam_time(LocalTime exam_time) {
		this.exam_time = exam_time;
	}

	public Subject getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(Subject subject_code) {
		this.subject_code = subject_code;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Lecturer getLecturer_ID() {
		return lecturer_ID;
	}

	public void setLecturer_ID(Lecturer lecturer_ID) {
		this.lecturer_ID = lecturer_ID;
	}
	
}
