
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.TeacherDto;
import java.util.List;


public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);
    TeacherDto getTeacherById(Long id);
    List<TeacherDto> getListTeacher();
    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
}
