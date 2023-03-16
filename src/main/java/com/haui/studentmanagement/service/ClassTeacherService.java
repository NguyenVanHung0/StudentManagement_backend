
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.ClassTeacherDto;
import java.util.List;


public interface ClassTeacherService {
    List<ClassTeacherDto> getClassTeacherByTeacherId(Long id);
    List<ClassTeacherDto> getClassTeacherByTeacherIdAndYear(Long teacherId, int year);
}
