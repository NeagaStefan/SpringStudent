package com.student.springstudent.Repository;

import com.student.springstudent.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findAllByTitleIgnoreCase(String title);


    Course findByTitle(String title);
}
