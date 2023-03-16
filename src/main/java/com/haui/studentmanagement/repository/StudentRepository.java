
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository extends JpaRepository<Student, Long>{
    @Query(value = "select * from student where user_id = ?1", nativeQuery = true)
    Student getStudentByUserId(Long id);
    
    @Query(value = "select * from student where code = ?1", nativeQuery = true)
    Student getStudentByCode(String code);
}
