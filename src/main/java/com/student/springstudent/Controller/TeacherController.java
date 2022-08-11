package com.student.springstudent.Controller;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.Repository.TeacherRepository;
import com.student.springstudent.Service.TeacherService;
import com.student.springstudent.entity.Teacher;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherService teacherService;



    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> fetchTeachers(){
        return ResponseEntity.ok(teacherRepository.findAll());
    }

//    @GetMapping("/teachers/{name}")
//    public Teacher getTeacherByFirstName(@PathVariable("name") String firstName) throws TeacherNotFoundException {
//        TeacherNotFoundException TeacherNotFoundException = new TeacherNotFoundException();
//        if(teacherRepository.findByFirstName(firstName)!= null) {
//            return  teacherRepository.findByFirstName(firstName);
//        }else throw TeacherNotFoundException;
//
//    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> fetchTeacherById(@PathVariable("id") Long id) throws TeacherNotFoundException {
        return ResponseEntity.ok(teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("it does not exist")));

    }

    @DeleteMapping("/teachers/{name}")
    public void deleteTeacherByName(@PathVariable("name") String firstName)throws TeacherNotFoundException {
        teacherRepository.deleteByFirstName(firstName);
    }

    @DeleteMapping("/teachers/delete/id/{id}")
    public String deleteTeacherById(@PathVariable ("id") Long teacherId) throws TeacherNotFoundException{
        teacherRepository.deleteById(teacherId);
        return "Teacher deleted";
    }


    @PostMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable ("id") Long teacherId, @RequestBody Teacher teacher) throws TeacherNotFoundException{
        return  ResponseEntity.ok(teacherService.updateTeacher(teacherId, teacher));
    }

    @GetMapping("/teachers/count")
    public ResponseEntity<Long> getTheNumberOfTeachers(){
        return ResponseEntity.ok(teacherService.teacherCount());
    }

}
