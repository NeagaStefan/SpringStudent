package com.student.springstudent.entity;

import lombok.Data;

@Data
public class CourseDto {
    private Long courseId;
    private String title;
    private Integer credits;
    private CourseMaterial courseMaterial;
    private Teacher teacher;
    private Student students;

}
