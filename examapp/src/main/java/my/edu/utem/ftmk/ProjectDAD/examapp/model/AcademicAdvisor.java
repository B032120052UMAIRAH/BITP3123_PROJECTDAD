package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class to provoke set and get attribute 
 * for table Academic Advisor
 * 
 * @author Group 18
 *
 */
@Entity
@Table(name = "academic_advisor")
public class AcademicAdvisor {
	
	@Id
	@Column(name = "advisor_ID")
	private String advisor_ID;
	
	@Column(name = "advisor_name")
	private String advisor_name;
	
	
	@Column(name = "advisor_phoneNumber")
	private int advisor_phoneNumber;
	
	@Column(name = "advisor_email")
	private String advisor_email;

	public String getAdvisor_ID() {
		return advisor_ID;
	}

	public void setAdvisor_ID(String advisor_ID) {
		this.advisor_ID = advisor_ID;
	}

	public String getAdvisor_name() {
		return advisor_name;
	}

	public void setAdvisor_name(String advisor_name) {
		this.advisor_name = advisor_name;
	}

	public int getAdvisor_phoneNumber() {
		return advisor_phoneNumber;
	}

	public void setAdvisor_phoneNumber(int advisor_phoneNumber) {
		this.advisor_phoneNumber = advisor_phoneNumber;
	}

	public String getAdvisor_email() {
		return advisor_email;
	}

	public void setAdvisor_email(String advisor_email) {
		this.advisor_email = advisor_email;
	}
	
	
	
}
