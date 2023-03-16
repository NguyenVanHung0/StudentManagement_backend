
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.StudentSubjectDto;
import java.util.List;


public interface StudentSubjectService {
    List<StudentSubjectDto> getStudentSubjectByStudentIdAndYear(Long studentId, int year);
}
