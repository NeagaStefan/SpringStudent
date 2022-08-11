package com.student.springstudent.Repository;

import com.student.springstudent.entity.Course;
import com.student.springstudent.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void SaveCourseMaterial() {
        Course course = Course.builder()
                .title("CSSP")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.stefanNeaga.com")
                .course(course)
                .build();

        repository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials= repository.findAll();
        System.out.println("CourseMaterials = " + courseMaterials);
    }




}