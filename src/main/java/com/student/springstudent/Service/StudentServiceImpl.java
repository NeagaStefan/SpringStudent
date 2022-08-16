package com.student.springstudent.Service;

import com.student.springstudent.Repository.StudentRepository;
import com.student.springstudent.entity.Student;
import com.student.springstudent.entity.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements  StudentService{

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;
    @Autowired
    private StudentServiceImpl(StudentRepository studentRepository,ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

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

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(student -> modelMapper.map(student,StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public Student save(StudentDto studentDto) {
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        return studentRepository.save(studentRequest);
        
    }
}
