package com.student.springstudent.Controller;

import com.student.springstudent.Error.CourseNotFoundException;
import com.student.springstudent.Repository.CourseRepository;
import com.student.springstudent.Service.CourseService;
import com.student.springstudent.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to the school database";

    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseRepository.findAll());

    }
    @GetMapping("/courses/{courseName}")
    public ResponseEntity<List<Course>> getAllCoursesByTitle(@PathVariable String courseName)throws CourseNotFoundException {
        return ResponseEntity.ok(courseRepository.findAllByTitle(courseName)) ;

    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveACourse(@RequestBody Course course){
        return ResponseEntity.ok(courseRepository.save(course));
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourseById(@PathVariable  Long courseId){
        courseRepository.deleteById(courseId);
    }

    @GetMapping("/courses/count")
    public Long numberOfCourses(){
        return courseService.coursesCount();
    }
}
