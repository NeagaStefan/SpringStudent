package com.student.springstudent.Service;

import com.student.springstudent.Error.TeacherNotFoundException;
import com.student.springstudent.Repository.TeacherRepository;
import com.student.springstudent.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher updateTeacher(Long teacherId, Teacher teacher){
        Teacher teacherDB = teacherRepository.findById(teacherId).get();
        if(Objects.nonNull(teacher.getFirstName())&& !"".equalsIgnoreCase(teacher.getFirstName())){
            teacherDB.setFirstName(teacher.getFirstName());
        }
        if(Objects.nonNull(teacher.getLastName())&& !"".equalsIgnoreCase(teacher.getLastName())){
            teacherDB.setLastName(teacher.getLastName());
        }
        if(Objects.nonNull(teacher.getCourses())&& !"".equalsIgnoreCase(teacher.getCourses().toString())){
            teacherDB.setCourses(teacher.getCourses());
        }
        return teacherRepository.save(teacherDB);
    }

    public Long teacherCount() {
        return teacherRepository.count();
    }


}
