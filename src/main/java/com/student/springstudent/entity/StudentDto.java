package com.student.springstudent.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentDto {
    private Long id;
    @NotBlank(message = "The first name must be filled")
    private String firstName;
    @NotBlank(message = "The last name must be filled")
    private String lastName;
    private String guardianName;
}
