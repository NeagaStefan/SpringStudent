package com.student.springstudent.Repository;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.entity.Student;
import com.student.springstudent.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Long> {
    Teacher findByFirstName(String firstName) throws TeacherNotFoundException;


//    List findByFirstNameOrLastName(String firstName);

    @Transactional
    void deleteByFirstName(String firstName) throws TeacherNotFoundException;

//    Teacher updateTeacher(Long teacherId, Teacher teacher);
}