package my.edu.utem.ftmk.ProjectDAD.examapp.model;

/**
 * This model class to provoke set and get attribute 
 * for table subject registration
 * 
 * @author Group 18
 *
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject_registration")
public class SubjectRegistration {
	
	public SubjectRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	//auto increment for new data
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subjReg_ID")
	private int subjReg_ID;
	
	//FK for subject registration  
	//join the subject registration table and student table
	@ManyToOne
    @JoinColumn(name="matricno")
    private Student matricno;
	
	//FK for subject registration  
	//join the subject registration table and subject table
	@ManyToOne
    @JoinColumn(name="subject_code")
    private Subject subject_code;
	
	public SubjectRegistration(int subjReg_ID, Student matricno, Subject subject_code) {
		super();
		this.subjReg_ID = subjReg_ID;
		this.matricno = matricno;
		this.subject_code = subject_code;
	}
	

	public int getSubjReg_ID() {
		return subjReg_ID;
	}

	public void setSubjReg_ID(int subjReg_ID) {
		this.subjReg_ID = subjReg_ID;
	}

	public Student getMatricno() {
		return matricno;
	}

	public void setMatricno(Student matricno) {
		this.matricno = matricno;
	}

	public Subject getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(Subject subject_code) {
		this.subject_code = subject_code;
	}


	
}
