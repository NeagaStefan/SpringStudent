package com.student.springstudent.Service;

import com.student.springstudent.Error.CourseNotFoundException;
import com.student.springstudent.Repository.CourseRepository;
import com.student.springstudent.entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private ModelMapper modelMapper;
    @Autowired
    public void CourseBeams (CourseRepository courseRepository,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    public Long coursesCount(){
        return courseRepository.count();

    }
    public List<Course> findAllByTitle(String title) throws CourseNotFoundException{
        try{
            return courseRepository.findAllByTitle(title);
        }catch (NoSuchElementException exception){
            throw new CourseNotFoundException("There were no courses with the title"+title);

        }

    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long courseId) {

    }

}
