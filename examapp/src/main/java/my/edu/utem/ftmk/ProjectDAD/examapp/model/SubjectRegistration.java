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
@Table(name = "subject_registration")
public class SubjectRegistration {
	
	public SubjectRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subjReg_ID")
	private int subjReg_ID;
	
	@ManyToOne
    @JoinColumn(name="matricno")
    private Student matricno;
	
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
