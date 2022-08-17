package com.student.springstudent.Controller;

import com.student.springstudent.Repository.StudentRepository;
import com.student.springstudent.Service.StudentService;
import com.student.springstudent.entity.Student;
import com.student.springstudent.entity.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;
    private StudentService studentService;

    @Autowired
    private StudentController (StudentRepository studentRepository, StudentService studentService){
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    //Saves a student
    //Done
    @PostMapping("/students")
    public ResponseEntity<Student> saveAStudent(@RequestBody StudentDto studentDto) {
        return  ResponseEntity.ok().body(studentService.save(studentDto));
    }

    //Displays the students
    //Done
    @GetMapping("/students")
    public List<StudentDto> showAllStudents(){
        return studentService.findAll();
    }

    //Deletes a student by id
    //Done
    @DeleteMapping("/students/{id}")
    public void deleteAStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    //Deletes a student
    //Done
    @DeleteMapping("/students/")
    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    //Updates a student
    //Done
    @PostMapping("/students/{id}")
    public Student updateAStudent(@PathVariable ("id") Long studentId, @RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentId, studentDto);

    }
}
