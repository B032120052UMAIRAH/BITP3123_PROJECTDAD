package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class for Academic Advisor Table
 * 
 * @author Syazwina
 *
 */
@Entity
@Table(name = "academic_advisor")
public class AcademicAdvisor {
	
	// Primary Key
	@Id
	@Column(name = "advisorId")
	private String advisorId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisor_Id(String advisorId) {
		this.advisorId = advisorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
