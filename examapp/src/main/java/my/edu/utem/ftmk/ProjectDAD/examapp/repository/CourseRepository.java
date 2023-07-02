package my.edu.utem.ftmk.ProjectDAD.examapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.ProjectDAD.examapp.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

}
