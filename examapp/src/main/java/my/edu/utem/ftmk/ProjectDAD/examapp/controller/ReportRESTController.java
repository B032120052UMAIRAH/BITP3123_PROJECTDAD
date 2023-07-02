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

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Report;
import my.edu.utem.ftmk.ProjectDAD.examapp.repository.ReportRepository;

/*CREATE BY GROUP 18
 * B032120025 - Imran
 * B032120040 - Syazwina
 * B032120052 - Umairah
*/

@RestController
@RequestMapping("/api/reports")
public class ReportRESTController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@GetMapping
	public List<Report> getReports()
	{
		return reportRepository.findAll();
		
	}
	
	//retrieve report details
	@GetMapping("{report_ID}")
	public Report getReport(@PathVariable long report_ID)
	{
		Report report  = reportRepository.findById(report_ID).get();
		
		return report;
	}
	
	//insert Report
	@PostMapping
	public Report insertReport(@RequestBody Report report)
	{
		return reportRepository.save(report);
	}
	
	//update Report
	@PutMapping
	public Report updateReport(@RequestBody Report report)
	{
		return reportRepository.save(report);
	}
	
	//delete Report
	@DeleteMapping("{report_ID}")
	public ResponseEntity<HttpStatus> deleteReport(@PathVariable long report_ID)
	{
		reportRepository.deleteById(report_ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
