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

    public Teacher updateTeacher(Long teacherId, TeacherDto teacherDto){
        Teacher teacherResponse = convertToEntity(teacherDto);
        Teacher teacherDB = teacherRepository.findById(teacherId).orElseThrow(()-> new TeacherNotFoundException("The teacher was not found"));

        if(Objects.nonNull(teacherResponse.getFirstName())&& !"".equalsIgnoreCase(teacherResponse.getFirstName())){
            teacherDB.setFirstName(teacherResponse.getFirstName());
        }
        if(Objects.nonNull(teacherResponse.getLastName())&& !"".equalsIgnoreCase(teacherResponse.getLastName())){
            teacherDB.setLastName(teacherResponse.getLastName());
        }
        if(Objects.nonNull(teacherResponse.getCourses())&& !"".equalsIgnoreCase(teacherResponse.getCourses().toString())){
            teacherDB.setCourses(teacherResponse.getCourses());
        }
        return teacherRepository.save(teacherDB);
    }

    public Long teacherCount() {
        return teacherRepository.count();
    }

    public Teacher changeTeacherLastName(TeacherDto teacherDto, Long id, String lastName) throws TeacherNotFoundException {
        Teacher teacherRequest = convertToEntity(teacherDto);
        Teacher teacherDB =  teacherRepository.findById(id).get();
        try{
            teacherDB.getTeacherId();

        }catch (NoSuchElementException exception){
            throw new TeacherNotFoundException("There is no teacher with this id");
        }
        if(Objects.nonNull(teacherRequest.getFirstName())&& !"".equalsIgnoreCase(teacherRequest.getFirstName())){
            teacherDB.setFirstName(teacherDto.getFirstName());
        }
        if(Objects.nonNull(teacherRequest.getLastName())&&!"".equalsIgnoreCase(teacherRequest.getLastName())){
            teacherDB.setLastName(lastName);
        }
        return teacherRepository.save(teacherDB);
    }

    @Override
    public List<TeacherDto> fetchTeachersByFirstNameIgnoreCase(String firstName) {

        return teacherRepository.findByFirstNameIgnoreCase(firstName).stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class)).collect(Collectors.toList());

    }

    //Done
    @Override

   public void deleteById(Long id){
        try{
            teacherRepository.deleteById(id);

        }catch (EmptyResultDataAccessException exception){
            throw new TeacherNotFoundException("The specified teacher does not exist");

        }

    }

    //Done
    @Override
    public ResponseEntity<TeacherDto> getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        TeacherDto teacherResponse = convertToDTo(teacher);
        return ResponseEntity.ok().body(teacherResponse);
    }

    //Done
    @Transactional
    @Override
    public void deleteTeacherByFirstName(String firstName) {
        teacherRepository.deleteByFirstName(firstName);
    }

    @Override
    public List<TeacherDto> findAll() {

        return teacherRepository.findAll().stream().map(teacher ->  modelMapper.map(teacher, TeacherDto.class)).collect(Collectors.toList());
    }


    private TeacherDto convertToDTo(Teacher teacher ) {
        return (modelMapper.map(teacher, TeacherDto.class));
    }

    private Teacher convertToEntity(TeacherDto teacherDto){
        return (modelMapper.map(teacherDto, Teacher.class));

    }



}
