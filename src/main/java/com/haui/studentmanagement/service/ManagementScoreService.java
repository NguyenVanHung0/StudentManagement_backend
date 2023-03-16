
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.ManagementScoreDto;
import java.util.List;


public interface ManagementScoreService {
    ManagementScoreDto createManagementScore(ManagementScoreDto managementScoreDto);
    List<ManagementScoreDto> getManagementScoreByStudentClassId(Long studentId, Long classId);
    ManagementScoreDto getManagementScoreBySubjectStudentClassId(Long studentId, Long subjectId, Long classId);
    List<ManagementScoreDto> getManagementScoreByTeacherClassIdAndyear(Long teacherId, Long classId, int year);
    ManagementScoreDto updateManagementScore(Long id, ManagementScoreDto managementScoreDto);
}
