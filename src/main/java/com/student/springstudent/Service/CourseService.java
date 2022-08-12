package com.student.springstudent.Service;

import com.student.springstudent.Error.CourseNotFoundException;
import com.student.springstudent.entity.Course;

import java.util.List;
import java.util.Optional;

//@Service
public interface CourseService {

    Long coursesCount();

//    Page<Course> findByTitleContaining(String title, Pageable pageRequest);

    List<Course> findAllByTitle(String title) throws CourseNotFoundException;

    List<Course> findAll();

    Optional<Course> findById(Long courseId);

    Course save(Course course);

    void deleteById(Long courseId);
}
