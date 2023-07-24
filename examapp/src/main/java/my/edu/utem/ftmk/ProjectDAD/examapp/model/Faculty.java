package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class for Faculty Table 
 * 
 * @author Imran
 *
 */
@Entity
@Table(name = "faculty")
public class Faculty {

	//Primary Key
	@Id
	@Column(name = "facultyCode")
	private String facultyCode;
	
	@Column(name = "name")
	private String name;

	public String getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(String facultyCode) {
		this.facultyCode = facultyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
