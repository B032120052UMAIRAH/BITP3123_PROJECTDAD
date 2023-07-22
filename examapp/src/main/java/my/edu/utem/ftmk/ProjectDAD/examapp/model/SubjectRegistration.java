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
 * @author user
 *
 */
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
	@Column(name = "subjRegId")
	private int subjRegId;
	
	//FK for subject registration  
	//join the subject registration table and student table
	@ManyToOne
    @JoinColumn(name="matricNo")
    private Student matricNo;
	
	//FK for subject registration  
	//join the subject registration table and subject table
	@ManyToOne
    @JoinColumn(name="subjectCode")
    private Subject subjectCode;
	

	public SubjectRegistration(int subjRegId, Student matricNo, 
			Subject subjectCode) {
		super();
		this.subjRegId = subjRegId;
		this.matricNo = matricNo;
		this.subjectCode = subjectCode;
	}


	public int getSubjRegId() {
		return subjRegId;
	}


	public void setSubjRegId(int subjRegId) {
		this.subjRegId = subjRegId;
	}


	public Student getMatricNo() {
		return matricNo;
	}


	public void setMatricNo(Student matricNo) {
		this.matricNo = matricNo;
	}


	public Subject getSubjectCode() {
		return subjectCode;
	}


	public void setSubjectCode(Subject subjectCode) {
		this.subjectCode = subjectCode;
	}
}
