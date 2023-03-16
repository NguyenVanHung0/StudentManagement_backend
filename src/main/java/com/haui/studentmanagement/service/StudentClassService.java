
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.StudentClassDto;
import java.util.List;

public interface StudentClassService {
    List<StudentClassDto> getListStudentClassByStudentId(Long studentId);
    List<StudentClassDto> getListStudentClassByClassId(Long classId);
}
