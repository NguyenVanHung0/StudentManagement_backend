
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.StudentSubject;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long>{
    @Query(value = "select * from student_subject where student_id = ?1 and year = ?2", nativeQuery = true)
    List<StudentSubject> getListStudentSubjectByIdAndYear(Long id, int year);
}
