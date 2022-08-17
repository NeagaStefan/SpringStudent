package com.student.springstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CourseDto {
    private Long courseId;
    @NotBlank(message = "The title is mandatory")
    private String title;
    @NotBlank(message = "The credit is mandatory")
    private Integer credit;
    @JsonIgnoreProperties(value = {"course","handler","hibernateLazyInitializer"}, allowSetters = true)
    private CourseMaterial courseMaterial;
    private Teacher teacher;
    private Student students;

}
