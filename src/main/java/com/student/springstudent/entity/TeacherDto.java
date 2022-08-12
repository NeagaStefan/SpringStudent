package com.student.springstudent.entity;

import lombok.Data;

@Data
public class TeacherDto {
    private long id;
    private String firstName;
    private String lastName;
    private Course courses;
}
