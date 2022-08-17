package com.student.springstudent.Service;

import com.student.springstudent.Repository.CourseRepository;
import com.student.springstudent.entity.Course;
import com.student.springstudent.entity.CourseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void CourseBeams(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    public Long coursesCount() {
        return courseRepository.count();

    }

    //Todo de facut metode separate de conversie cu transient
    public List<CourseDto> findAllByTitleIgnoreCase(String title) {
        return courseRepository.findAllByTitleIgnoreCase(title).stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());

    }

    //Done
    @Override
    public List<CourseDto> findAll() {

        return courseRepository.findAll().stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<CourseDto> findById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        CourseDto courseResponse = convertToDTo(course);
        return ResponseEntity.ok().body(courseResponse);
    }

    @Override
    public Course save(CourseDto courseDto) {
        Course courseRequest = convertToEntity(courseDto);
        return courseRepository.save(courseRequest);
    }

    @Override
    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course update(String title, CourseDto courseDto) {
        Course courseRequest = convertToEntity(courseDto);
        Course courseDb = courseRepository.findByTitle(title);
        if (Objects.nonNull(courseRequest.getCredit())) {
            courseDb.setCredit(courseRequest.getCredit());
        }
        if (Objects.nonNull(courseRequest.getTeacher())) {
            courseDb.setTeacher(courseRequest.getTeacher());
        }
        courseDb.setTitle(title);

        return courseRepository.save(courseDb);
    }


    private CourseDto convertToDTo(Course course) {
        return (modelMapper.map(course, CourseDto.class));
    }

    private Course convertToEntity(CourseDto courseDto){
        return (modelMapper.map(courseDto,Course.class));
    }
}


//TODO input validation on tdo
//Todo querrys
