package com.student.springstudent.Service;

import com.student.springstudent.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Long coursesCount(){
        return courseRepository.count();

    }

}
