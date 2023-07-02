package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Attendance;


public interface AttendanceRepository extends JpaRepository<Attendance, String> {

}
