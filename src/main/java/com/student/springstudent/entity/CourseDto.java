package com.student.springstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class CourseDto {
    private Long courseId;
    private String title;
    private Integer credit;
    @JsonIgnoreProperties(value = {"course","handler","hibernateLazyInitializer"}, allowSetters = true)
    private CourseMaterial courseMaterial;
    private Teacher teacher;
    private Student students;

}
