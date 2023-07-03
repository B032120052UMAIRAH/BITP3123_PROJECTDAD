package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.StudentAttendance;



/**
 * First Query
 * 
 * The @Query annotation specifies a custom SQL query that will be executed to fetch the data.
 * The value attribute of the @Query annotation contains the SQL query string.
 * 
 * The SQL query selects specific columns (attendance_ID, matricno, dateTime, exam_code, attendance_method, status) 
 * from three tables: student_attendance, student, and examination.
 * 
 * The query includes a WHERE clause that filters the results based on certain conditions:
 * a.matricno = m.matricno ensures that the matricno values in the student_attendance and student tables match.
 * a.exam_code = e.exam_code ensures that the exam_code values in the student_attendance and examination tables match.
 * a.status LIKE '%absent' selects only the rows where the status column ends with "absent".
 * 
 * The nativeQuery attribute is set to true, indicating that the SQL query is a native SQL query.
 * The return type of the method is List<StudentAttendance>, specifying that the query results should be
 * mapped to a list of StudentAttendance objects.
 * 
 * In summary, this code executes a custom SQL query to retrieve specific columns from multiple tables, applying certain conditions in the WHERE clause. 
 * The query is executed as a native SQL query, and the results are mapped to a list of StudentAttendance objects.
 * 
 * 
 * Second Query
 * 
 * The @Query annotation specifies a custom SQL query that will be executed to fetch the data.
 * The value attribute of the @Query annotation contains the SQL query string.
 * 
 * The SQL query selects specific columns (attendance_ID, matricno, dateTime, exam_code, attendance_method, status) 
 * from three tables: student_attendance, student, and examination.
 * 
 * The query includes a WHERE clause that filters the results based on certain conditions:
 * a.matricno = m.matricno ensures that the matricno values in the student_attendance and student tables match.
 * a.exam_code = e.exam_code ensures that the exam_code values in the student_attendance and examination tables match.
 * a.status LIKE '%present' selects only the rows where the status column ends with "present".
 * 
 * The nativeQuery attribute is set to true, indicating that the SQL query is a native SQL query.
 * 
 * The return type of the method is List<StudentAttendance>, specifying that the query results should 
 * be mapped to a list of StudentAttendance objects.
 * 
 * In summary, this code executes a custom SQL query to retrieve specific columns from 
 * multiple tables, applying certain conditions in the WHERE clause. 
 * The query is executed as a native SQL query, and the results are mapped to a list 
 * of StudentAttendance objects. This particular query selects rows where the status column ends with "present".
 * 
 * 
 * @author Umairah (B032120052)
 *
 */
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
