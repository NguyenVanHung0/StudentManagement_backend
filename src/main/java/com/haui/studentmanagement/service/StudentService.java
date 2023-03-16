
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.StudentDto;
import java.util.List;


public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getListStudent();
    StudentDto getStudentByUserId(Long id);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    StudentDto getStudentByCode(String code);
}
