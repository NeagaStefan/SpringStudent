package com.student.springstudent.Repository;

import com.student.springstudent.entity.Course;
import com.student.springstudent.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    public TeacherRepository teacherRepository;


    @Test
    public void saveTeacher() {

        Course courseOM1 = Course.builder()
                .title("CCA2")
                .credit(5)
                .build();

        Course courseCCA2 = Course.builder()
                .title("CCA2")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Noah")
                .lastName("Trevor")
                //.courses(List.of(courseOM1,courseCCA2))
                .build();
        teacherRepository.save(teacher);

    }
}