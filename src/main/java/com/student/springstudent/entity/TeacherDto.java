package com.student.springstudent.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TeacherDto {
    private long id;
    @NotBlank(message = "The first name must be filled")
    private String firstName;
    @NotBlank(message = "The last name must be filled")
    private String lastName;
    @NotBlank(message = "The course must be filled")
    private Course courses;
}
