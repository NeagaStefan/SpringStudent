package com.student.springstudent.Controller;

import com.student.springstudent.Repository.StudentRepository;
import com.student.springstudent.Service.StudentService;
import com.student.springstudent.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public StudentService studentService;

    @PostMapping("/students")
    public Student saveAStudent(@RequestBody Student student) {
        return  studentRepository.save(student);
    }

    @GetMapping("/students")
    public List showAllStudents(){
        return studentRepository.findAll();
    }

    @DeleteMapping("/students/{id}")
    public void deleteAStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/students/")
    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    @PostMapping("/students/{id}")
    public Student updateAStudent(@PathVariable ("id") Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);

    }
}
