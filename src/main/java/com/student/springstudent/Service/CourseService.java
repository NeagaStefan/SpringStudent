package com.student.springstudent.Service;

import com.student.springstudent.Error.CourseNotFoundException;
import com.student.springstudent.entity.Course;
import com.student.springstudent.entity.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

//@Service
public interface CourseService {

    Long coursesCount();

//    Page<Course> findByTitleContaining(String title, Pageable pageRequest);

    List<CourseDto> findAllByTitleIgnoreCase(String title) throws CourseNotFoundException;

    List<CourseDto> findAll();

    ResponseEntity<CourseDto> findById(Long courseId);

    Course save(CourseDto courseDto);

    void deleteById(Long courseId);

    Course update(String title,CourseDto courseDto);
}
