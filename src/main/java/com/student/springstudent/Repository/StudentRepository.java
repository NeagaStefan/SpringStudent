package com.student.springstudent.Repository;

import com.student.springstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//
//
//    List<Student> findByFirstName(String firstName);
//    List<Student> findByFirstNameContaining(String name);
//    List<Student> findByLastNameNotNull();
//    List<Student> findByGuardianName(String name);
//
//    @Query("select s from Student s where s.email =?1")
//    Student getStudentByEmailAddress(String email);
//
//    @Query(value = "SELECT * from tbl_student  where email = ?1",
//    nativeQuery = true)
//    Student getStudentByEmailAddressNative(String email);
//
//    @Query(value = "SELECT * from tbl_student  where email = :email",
//            nativeQuery = true)
//    Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

//    Student updateStudent(Long studentId, Student student);
}
