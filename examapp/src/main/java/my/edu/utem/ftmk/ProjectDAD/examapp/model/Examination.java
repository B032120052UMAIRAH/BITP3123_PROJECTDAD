package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author user
 *
 */
@Entity
@Table(name ="examination")
public class Examination {
	
	//auto increment for new data
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "examCode")
	private int examCode;
	
	@Column(name = "venue")
	private String venue;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private LocalTime time;
	
	//FK for TABLE Subject 
	//join the examination table and subject table
	@ManyToOne
    @JoinColumn(name="subjectCode")
    private Subject subjectCode;
	
	@Column(name = "duration")
	private int duration;
	
	//FK for TABLE Lecturer 
	//join the examination table and lecturer table
	@ManyToOne
    @JoinColumn(name="lecturerId")
    private Lecturer lecturerId;
	
	public Examination() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Examination(int examCode, String venue, String date, LocalTime time, Subject subjectCode, int duration,
			Lecturer lecturerId) {
		super();
		this.examCode = examCode;
		this.venue = venue;
		this.date = date;
		this.time = time;
		this.subjectCode = subjectCode;
		this.duration = duration;
		this.lecturerId = lecturerId;
	}

	public int getExamCode() {
		return examCode;
	}

	public void setExamCode(int examCode) {
		this.examCode = examCode;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Subject getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(Subject subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Lecturer getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Lecturer lecturerId) {
		this.lecturerId = lecturerId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}
