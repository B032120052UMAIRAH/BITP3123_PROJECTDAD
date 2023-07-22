package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.StudentAttendance;

/**
 * @author user
 *
 */
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {

	
	@Query(value="select a.attendanceId, m.matricNo,m.name, a.dateTime,"
			+ " e.examCode, e.venue,e.date,e.time,e.duration,s.subjectCode, a.method, a.status"
			+ " FROM student_attendance a "
			+ " JOIN examination e ON a.examCode = e.examCode"
			+ " JOIN subject s ON e.subjectCode = s.subjectCode"
			+ " JOIN student m ON a.matricNo = m.matricNo"
			+ " WHERE a.status LIKE '%absent' ",
			nativeQuery=true)
	public List<StudentAttendance>selectCustomByCode();
	
	@Query(value="select a.attendanceId, m.matricNo,m.name, a.dateTime,"
			+ " e.examCode, e.venue,e.date,e.time,e.duration,s.subjectCode, a.method, a.status"
			+ " FROM student_attendance a "
			+ " JOIN examination e ON a.examCode = e.examCode"
			+ " JOIN subject s ON e.subjectCode = s.subjectCode"
			+ " JOIN student m ON a.matricNo = m.matricNo"
			+ " WHERE a.status LIKE '%present' ",
			nativeQuery=true)
	public List<StudentAttendance>selectCustomByCodePresent();

//	@Query(value="select a.attendanceId, m.matricNo,m.name, a.dateTime,"
//			+ " e.examCode, e.venue,e.date,e.time,e.duration, a.method, a.status"
//			+ " FROM student_attendance a, student m, examination e "
//			+ " WHERE a.matricNo = m.matricNo AND a.examCode = e.examCode AND a.status LIKE '%absent' ",
//			nativeQuery=true)
//	public List<StudentAttendance>selectCustomByCode();
	
	/*
	 * @Query(value="select a.attendanceId, m.matricNo,m.name, a.dateTime, " +
	 * " e.examCode,e.venue,e.date,e.time,e.duration, a.method, a.status" +
	 * " FROM student_attendance a, student m, examination e" +
	 * " WHERE a.matricNo = m.matricNo AND a.examCode = e.examCode AND a.status LIKE '%present' "
	 * , nativeQuery=true) public
	 * List<StudentAttendance>selectCustomByCodePresent();
	 */
}
