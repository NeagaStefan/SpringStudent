package com.student.springstudent.Controller;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.Repository.TeacherRepository;
import com.student.springstudent.Service.TeacherService;
import com.student.springstudent.entity.Teacher;
import com.student.springstudent.entity.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

        private TeacherRepository teacherRepository;
        private TeacherService teacherService;

    @Autowired
    private TeacherController ( TeacherRepository teacherRepository, TeacherService teacherService){

        this.teacherRepository = teacherRepository;
        this.teacherService = teacherService;
    }
    //Displays the teachers
    //Done
     @GetMapping("/teachers")
    public List<TeacherDto> fetchTeachers() {

        return teacherService.findAll();
    }

    //Displays teacher by id
    //Done
    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherDto> fetchTeacherById(@PathVariable("id") Long id) throws TeacherNotFoundException {

        return ResponseEntity.ok(teacherService.getTeacherById(id).getBody());

    }
    //Displays a teacher by first name
    //Done

    @GetMapping("/teachers/")
    public List<TeacherDto> fetchTeacherByFirstNameIgnoreCase(@RequestParam String lastName){

        return teacherService.fetchTeachersByFirstNameIgnoreCase(lastName);

    }

    //Deletes a teacher by first name
    //Done
    @DeleteMapping("/teachers/{firstName}")
    public void deleteTeacherByName(@PathVariable("firstName") String firstName) throws TeacherNotFoundException {
        teacherService.deleteTeacherByFirstName(firstName);
    }

    //Deletes a teacher by id
    //Done
    @DeleteMapping("/teachers/")
    public void deleteTeacherByName(@RequestParam Long id) throws TeacherNotFoundException {
        teacherService.deleteById(id);
    }

    //Updates a teacher
    //Todo
    @PostMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long teacherId, @RequestBody Teacher teacher) throws TeacherNotFoundException {
        return ResponseEntity.ok(teacherService.updateTeacher(teacherId, teacher));
    }

    //Displays the total of teachers
    //Done
    @GetMapping("/teachers/count")
    public ResponseEntity<Long> getTheNumberOfTeachers() {
        return ResponseEntity.ok(teacherService.teacherCount());
    }

    @PutMapping("/teachers/")
    public void updateTheLastName(@RequestParam Long id, @RequestParam String name, @RequestBody Teacher teacher) {
        ResponseEntity.ok(teacherService.changeTeacherLastName(teacher, id, name));
    }
}