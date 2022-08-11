package com.student.springstudent.Service;

import com.student.springstudent.Repository.CourseRepository;
import com.student.springstudent.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

}
