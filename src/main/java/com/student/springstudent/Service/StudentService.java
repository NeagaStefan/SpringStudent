package com.student.springstudent.Service;

import com.student.springstudent.entity.Student;

public interface StudentService {
    Student updateStudent(Long studentId, Student student);
}
