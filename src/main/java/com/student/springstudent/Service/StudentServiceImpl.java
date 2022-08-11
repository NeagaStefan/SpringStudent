package com.student.springstudent.Service;

import com.student.springstudent.Repository.StudentRepository;
import com.student.springstudent.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentServiceImpl implements  StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student updateStudent(Long studentId, Student student){
        Student student1 = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getFirstName())&& !"".equalsIgnoreCase(student.getFirstName())){
            student1.setFirstName(student.getFirstName());
        }
        if(Objects.nonNull(student.getLastName())&& !"".equalsIgnoreCase(student.getLastName())){
            student1.setLastName(student.getLastName());
        }
        if(Objects.nonNull(student.getEmail())&& !"".equalsIgnoreCase(student.getEmail())){
            student1.setEmail(student.getEmail());
        }
        return studentRepository.save(student1);
    }
}
