package com.student.springstudent.Controller;

import com.student.springstudent.Repository.CourseRepository;
import com.student.springstudent.Service.CourseService;
import com.student.springstudent.entity.Course;
import com.student.springstudent.entity.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {


    private CourseRepository courseRepository;
    private CourseService courseService;

    @Autowired

    private CourseController( CourseService courseService, CourseRepository courseRepository){
        this.courseRepository = courseRepository;
        this.courseService =courseService;
    }
    //Displays a welcome message
    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to the school database";

    }
    //Displays all courses
    //Done
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

    //Displays a course by title
    //Done
    @GetMapping("/courses/")
    public ResponseEntity<List<CourseDto>> getAllCoursesByTitle(@RequestParam String name) {
        return ResponseEntity.ok(courseService.findAllByTitleIgnoreCase(name)) ;

    }

    //Displays a course by id
    //Done
    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseService.findById(id).getBody());

    }

    //Saves a new course
    //Done
    @PostMapping("/courses")
    public ResponseEntity<Course> saveACourse(@Valid @RequestBody CourseDto courseDto){
        return ResponseEntity.ok().body(courseService.save(courseDto));
    }

//    Updates a course by title
//    TODO
    @PutMapping("/courses/{title}")
    public ResponseEntity<Course> updateACourse(@Valid @PathVariable ("title") String title, @RequestBody CourseDto courseDto){
        return ResponseEntity.ok().body(courseService.update(title,courseDto));
    }

    //Deletes a course
    //Done
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourseById(@PathVariable  Long courseId){
        courseService.deleteById(courseId);
    }

    //Displays the number of courses
    //Done
    @GetMapping("/courses/count")
    public Long numberOfCourses(){
        return courseService.coursesCount();
    }
}
