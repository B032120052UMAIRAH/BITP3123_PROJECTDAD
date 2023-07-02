package my.edu.utem.ftmk.ProjectDAD.examapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "venue")
public class Venue {

	@Id
	@Column(name = "venue_code")
	private String venue_code;
	
	@Column(name = "venue_name")
	private String venue_name;

	public String getVenue_code() {
		return venue_code;
	}

	public void setVenue_code(String venue_code) {
		this.venue_code = venue_code;
	}

	public String getVenue_name() {
		return venue_name;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	
	
}
