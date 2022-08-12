package com.student.springstudent.Service;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.Repository.TeacherRepository;
import com.student.springstudent.entity.Teacher;
import com.student.springstudent.entity.TeacherDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    // Constructor based injection
        private TeacherRepository teacherRepository;
        private ModelMapper modelMapper;


    @Autowired
        public void TeacherBeams(TeacherRepository teacherRepository, ModelMapper modelMapper) {
            this.teacherRepository = teacherRepository;
            this.modelMapper = modelMapper;
    }

    public Teacher updateTeacher(Long teacherId, Teacher teacher){
        Teacher teacherDB = teacherRepository.findById(teacherId).orElseThrow(()-> new TeacherNotFoundException("The teacher was not found"));

        if(Objects.nonNull(teacher.getFirstName())&& !"".equalsIgnoreCase(teacher.getFirstName())){
            teacherDB.setFirstName(teacher.getFirstName());
        }
        if(Objects.nonNull(teacher.getLastName())&& !"".equalsIgnoreCase(teacher.getLastName())){
            teacherDB.setLastName(teacher.getLastName());
        }
        if(Objects.nonNull(teacher.getCourses())&& !"".equalsIgnoreCase(teacher.getCourses().toString())){
            teacherDB.setCourses(teacher.getCourses());
        }
        return teacherRepository.save(teacherDB);
    }

    public Long teacherCount() {
        return teacherRepository.count();
    }

    public Teacher changeTeacherLastName(Teacher teacher,Long id, String lastName) throws TeacherNotFoundException {
        Teacher teacherDB =  teacherRepository.findById(id).get();
        try{
            teacherDB.getTeacherId();

        }catch (NoSuchElementException exception){
            throw new TeacherNotFoundException("There is no teacher with this id");
        }
        if(Objects.nonNull(teacher.getFirstName())&& !"".equalsIgnoreCase(teacher.getFirstName())){
            teacherDB.setFirstName(teacher.getFirstName());
        }
        if(Objects.nonNull(teacher.getLastName())&&!"".equalsIgnoreCase(teacher.getLastName())){
            teacherDB.setLastName(lastName);
        }
        return teacherRepository.save(teacherDB);
    }

    @Override
    public List<TeacherDto> fetchTeachersByFirstNameIgnoreCase(String firstName) {

        return teacherRepository.findByFirstNameIgnoreCase(firstName).stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class)).collect(Collectors.toList());

    }

    @Override
    //TODO make DTO for all


   public void deleteById(Long id){
        try{
            teacherRepository.deleteById(id);

        }catch (EmptyResultDataAccessException exception){
            throw new TeacherNotFoundException("The specified teacher does not exist");

        }

    }

    @Override
    public ResponseEntity<TeacherDto> getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        TeacherDto teacherResponse = modelMapper.map(teacher, TeacherDto.class);
        return ResponseEntity.ok().body(teacherResponse);
    }

    @Transactional
    @Override
    public void deleteTeacherByFirstName(String firstName) {
        teacherRepository.deleteByFirstName(firstName);
    }

    @Override
    public List<TeacherDto> findAll() {

        return teacherRepository.findAll().stream().map(teacher ->  modelMapper.map(teacher, TeacherDto.class)).collect(Collectors.toList());
    }



}
