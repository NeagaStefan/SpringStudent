//package com.student.springstudent.Repository;
//
//import com.student.springstudent.entity.Course;
//import com.student.springstudent.entity.Student;
//import com.student.springstudent.entity.Teacher;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//
//
//@SpringBootTest
//class CourseRepositoryTest {
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Test
//    public void printCourses(){
//        List<Course> courses= courseRepository.findAll();
//        System.out.println("Courses = " +courses);
//    }
//
//    @Test
//    public void saveCourseWithFeatureObject(){
//        Teacher teacher = Teacher.builder()
//                .firstName("Fane")
//                .lastName("Lautaru")
//                .build();
//        Course course = Course.builder()
//                .credit(7)
//                .title("Python")
//                .teacher(teacher)
//                .build();
//        courseRepository.save(course);
//    }
//
//    @Test
//    public void  findAllPagination () {
//        Pageable firstPageWithThreeRecords =  PageRequest.of(0,3);
//        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
//
//        List<Course> courses =  courseRepository.findAll(firstPageWithThreeRecords).getContent();
//        System.out.println("Courses = " + courses);
//
//        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
//        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
//        System.out.println("Total pages = "+totalPages);
//        System.out.println("Total elements = "+ totalElements);
//    }
//
//    @Test
//    public void findAllSorting(){
//        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
//        Pageable sortByCreditDesc = PageRequest.of(0,2,Sort.by("credit").descending());
//        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("Credit")));
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//        System.out.println("Courses = "+courses);
//    }
//    @Test
//    public void printFindByTitleContaining(){
//        Pageable firstPageTenRecords =
//                PageRequest.of(0,10);
//        List<Course> courses = courseRepository.findByTitleContaining("C", firstPageTenRecords).getContent();
//        System.out.println("Courses ="+ courses);
//    }
//    @Test
//    public void saveCourseWithStudentAndTeacher() {
//        Teacher teacher = Teacher.builder()
//                .firstName("Dada")
//                .lastName("Nunu")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Lucrian")
//                .lastName("Corbu")
//                .email("lucian06@yahoo.com")
//                .build();
//        Course course = Course.builder()
//                .title("AI")
//                .credit(4)
//                .teacher(teacher)
//                .build();
//
//        course.addStudents(student);
//        courseRepository.save(course);
//    }
//}