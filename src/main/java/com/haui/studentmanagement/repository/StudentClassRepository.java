
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.StudentClass;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentClassRepository extends JpaRepository<StudentClass, Long>{
    @Query(value = "select * from student_class where student_id = ?1", nativeQuery = true)
    List<StudentClass> getListStudentClassByStudentId(Long studentId);
    
    @Query(value = "select * from student_class where class_id = ?1", nativeQuery = true)
    List<StudentClass> getListStudentClassByClassId(Long classId);
}
