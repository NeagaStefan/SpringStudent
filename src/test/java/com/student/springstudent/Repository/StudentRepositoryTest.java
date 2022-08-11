//package com.student.springstudent.Repositry;
//
//import com.student.springstudent.entity.Guardian;
//import com.student.springstudent.entity.Student;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class StudentRepositoryTest {
//
//    @Autowired
//    private  StudentRepository studentRepository;
//
//    @Test
//    public void saveStudent() {
//        Student student = Student.builder()
//                .email("dasfasfas@gmail.com")
//                .firstName("Stefan")
//                .lastName("Neaga").build();
//                //.guardianName("Viorel")
//                //.// guardianEmail("bio@gmail.com")
//                //.guardianMobile("0746564656").build();
//
//        studentRepository.save(student);
//    }
//
//    @Test
//    public void saveStudentWithGuardian() {
//        Guardian guardian = Guardian.builder()
//                .email("viior@gmail.com")
//                .mobile("45646546211")
//                .name("Vio")
//                .build();
//        Student student = Student.builder()
//                .firstName("Stefan")
//                .lastName("Neaga")
//                .email("dhaijdh@gmail.com")
//                .guardian(guardian)
//                .build();
//        studentRepository.save(student);
//    }
//
//
//    @Test
//    public void printAllStudents(){
//        List<Student> studentList = studentRepository.findAll();
//        System.out.println("Student list" + studentList);
//    }
//
//    @Test
//    public void printStudentByFirstName(){
//        List<Student> students = studentRepository.findByFirstName("Stefan");
//        System.out.println("Students = " +students);
//    }
//
//    @Test
//    public void printStudentBasedOnGuardianName() {
//        List<Student> students= studentRepository.findByGuardianName("Vio");
//        System.out.println("Students = "+students);
//    }
//
//    @Test
//    public void printGetStudentByEmailAddress(){
//        Student student = studentRepository.getStudentByEmailAddress("dhaijdh@gmail.com");
//        System.out.println("Student: "+ student);
//    }
//
//    @Test
//    public void printGetStudentByEmailNative(){
//        Student student = studentRepository.getStudentByEmailAddressNative("dhaijdh@gmail.com");
//        System.out.println("Student "+ student);
//    }
//
//    @Test
//    public void getStudentByEmailAddressNativeNamedParam(){
//        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("dhaijdh@gmail.com");
//        System.out.println("Student "+ student);
//    }
//
//
//}