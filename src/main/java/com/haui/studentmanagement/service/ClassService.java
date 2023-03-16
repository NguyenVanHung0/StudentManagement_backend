
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.ClassDto;


public interface ClassService {
    ClassDto createClass(ClassDto classDto);
    ClassDto getClassById(Long id);
}
