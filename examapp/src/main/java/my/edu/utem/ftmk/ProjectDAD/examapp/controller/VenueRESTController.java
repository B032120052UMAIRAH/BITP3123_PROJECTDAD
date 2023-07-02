package my.edu.utem.ftmk.ProjectDAD.examapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Venue;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.VenueRepository;

/*author by GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/venues")
public class VenueRESTController {
	
	@Autowired
	private VenueRepository venueRepository;
	
	@GetMapping
	public List<Venue> getVenues()
	{
		return venueRepository.findAll();
		
	}
	
	//retrieve venue details using venue_code as ID
	@GetMapping("{venue_code}")
	public Venue getVenue(@PathVariable String venue_code)
	{
		Venue venue  = venueRepository.findById(venue_code).get();
		
		return venue;
	}
	
	//insert venue 
	@PostMapping
	public Venue insertVenue(@RequestBody Venue venue)
	{
		return venueRepository.save(venue);
	}
	
	//update venue 
	@PutMapping
	public Venue updateVenue(@RequestBody Venue venue)
	{
		return venueRepository.save(venue);
	}
	
	//delete venue by ID (venue code)
	@DeleteMapping("{venue_code}")
	public ResponseEntity<HttpStatus> deleteVenue(@PathVariable String venue_code)
	{
		venueRepository.deleteById(venue_code);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
