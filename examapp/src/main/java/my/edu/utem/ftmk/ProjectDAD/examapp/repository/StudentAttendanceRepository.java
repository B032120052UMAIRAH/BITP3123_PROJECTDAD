package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.StudentAttendance;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {

	@Query(value="select a.attendance_ID, m.matricno, a.dateTime, e.exam_code, a.attendance_method, a.status"
			+ " FROM student_attendance a, student m, examination e "
			+ " WHERE a.matricno = m.matricno AND a.exam_code = e.exam_code AND a.status LIKE '%absent' ",
			nativeQuery=true)
	public List<StudentAttendance>selectCustomByCode();
	
	@Query(value="select a.attendance_ID, m.matricno, a.dateTime, e.exam_code, a.attendance_method, a.status"
			+ " FROM student_attendance a, student m, examination e "
			+ " WHERE a.matricno = m.matricno AND a.exam_code = e.exam_code AND a.status LIKE '%present' ",
			nativeQuery=true)
	public List<StudentAttendance>selectCustomByCodePresent();
}
