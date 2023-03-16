
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.SchoolDto;

public interface SchoolService {
    SchoolDto createSchool(SchoolDto schoolDto);
    SchoolDto getSchoolById(Long id);
}
