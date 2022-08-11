package com.student.springstudent.Service;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherService {
    Teacher updateTeacher(Long teacherId, Teacher teacher) throws TeacherNotFoundException;

    Long teacherCount() throws TeacherNotFoundException;
}
