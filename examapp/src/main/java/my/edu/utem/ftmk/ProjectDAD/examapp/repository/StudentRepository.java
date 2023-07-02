package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
