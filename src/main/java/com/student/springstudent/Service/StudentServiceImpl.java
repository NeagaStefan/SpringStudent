package com.student.springstudent.Service;

import com.student.springstudent.Repository.StudentRepository;
import com.student.springstudent.entity.Student;
import com.student.springstudent.entity.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Student updateStudent(Long studentId, StudentDto studentDto){
        Student studentRequest = convertToEntity(studentDto);
        Student student1 = studentRepository.findById(studentId).get();
        if(Objects.nonNull(studentRequest.getFirstName())&& !"".equalsIgnoreCase(studentRequest.getFirstName())){
            student1.setFirstName(studentRequest.getFirstName());
        }
        if(Objects.nonNull(studentRequest.getLastName())&& !"".equalsIgnoreCase(studentRequest.getLastName())){
            student1.setLastName(studentRequest.getLastName());
        }
        if(Objects.nonNull(studentRequest.getEmail())&& !"".equalsIgnoreCase(studentRequest.getEmail())){
            student1.setEmail(studentRequest.getEmail());
        }
        return studentRepository.save(student1);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(student -> modelMapper.map(student,StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public Student save(StudentDto studentDto) {
        Student studentRequest = convertToEntity(studentDto);
        return studentRepository.save(studentRequest);
        
    }
    public StudentDto convertToDto(Student student) {
        return (modelMapper.map(student, StudentDto.class));

    }
    public  Student convertToEntity(StudentDto studentDto){
        return (modelMapper.map(studentDto, Student.class));
    }
}
