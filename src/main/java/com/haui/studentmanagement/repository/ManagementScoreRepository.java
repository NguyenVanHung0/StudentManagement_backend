
package com.haui.studentmanagement.repository;

import com.haui.studentmanagement.model.ManagementScore;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ManagementScoreRepository extends JpaRepository<ManagementScore, Long>{
    @Query(value = "select * from management_score where student_id = ?1 and class_id = ?2", nativeQuery = true)
    List<ManagementScore> getManagementScoreByStudentClassId(Long studentId, Long classId);
    
    @Query(value = "select * from management_score where student_id = ?1 and subject_id = ?2 and class_id = ?3", nativeQuery = true)
    ManagementScore getManagementScoreByStudentSubjectClassId(Long studentId, Long subjectId, Long classId);
    
    @Query(value = "select * from management_score where teacher_id = ?1 and class_id = ?2 and year = ?3", nativeQuery = true)
    List<ManagementScore> getManagementScoreByTeacherClassIdAndYear(Long teacherId, Long classId, int year);
}
