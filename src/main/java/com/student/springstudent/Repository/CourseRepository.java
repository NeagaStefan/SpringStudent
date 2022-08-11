package com.student.springstudent.Repository;

import com.student.springstudent.Error.CourseNotFoundException;
import com.student.springstudent.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Page<Course> findByTitleContaining(String title, Pageable pageRequest);

    List<Course>findAllByTitle(String title) throws CourseNotFoundException;
}
