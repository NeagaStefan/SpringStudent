package com.student.springstudent.Service;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.entity.Teacher;
import com.student.springstudent.entity.TeacherDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService  {
    Teacher updateTeacher(Long teacherId, Teacher teacher) throws TeacherNotFoundException;

    Long teacherCount() throws TeacherNotFoundException;

    Teacher changeTeacherLastName(Teacher teacher,Long id, String lastName) throws TeacherNotFoundException;

    List<TeacherDto> fetchTeachersByFirstNameIgnoreCase(String firstName);

    void deleteTeacherByFirstName(String firstName);

    List<TeacherDto> findAll();

    void deleteById(Long id);

    ResponseEntity<TeacherDto> getTeacherById(Long id);
}
