package com.student.springstudent.Repository;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.entity.Teacher;
import com.student.springstudent.entity.TeacherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Long> {

    void deleteByFirstName(String firstName) throws TeacherNotFoundException;

    List<TeacherDto> findByFirstNameIgnoreCase(String firstName);



}