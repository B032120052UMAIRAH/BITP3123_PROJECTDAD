package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This model class for Subject Table 
 * 
 * @author Umairah
 *
 */
@Entity
@Table(name = "subject")
public class Subject {

	//Primary Key
	@Id
	@Column(name = "subjectCode")
	private String subjectCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "courseCode")
	private String courseCode;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	
}
