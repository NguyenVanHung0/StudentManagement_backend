
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.ClassTeacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClassTeacherRepository extends JpaRepository<ClassTeacher, Long>{
    @Query(value = "select * from class_teacher where teacher_id = ?1", nativeQuery = true)
    List<ClassTeacher> getClassTeacherByTeacherId(Long teacherId);
    
    @Query(value = "select * from class_teacher where teacher_id = ?1 and year = ?2", nativeQuery = true)
    List<ClassTeacher> getClassTeacherByTeacherIdAndYear(Long teacherId, int year);
    
}
