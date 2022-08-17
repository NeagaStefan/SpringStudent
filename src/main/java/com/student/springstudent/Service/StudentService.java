package com.student.springstudent.Service;

import com.student.springstudent.entity.Student;
import com.student.springstudent.entity.StudentDto;

import java.util.List;

public interface StudentService {
    Student updateStudent(Long studentId, StudentDto studentDto);

    List<StudentDto> findAll();

    Student save(StudentDto studentDto);
}
