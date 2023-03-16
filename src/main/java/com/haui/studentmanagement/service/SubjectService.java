
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.SubjectDto;
import java.util.List;


public interface SubjectService {
    SubjectDto createSubject(SubjectDto subjectDto);
    SubjectDto getSubjectById(Long id);
    List<SubjectDto> getListSubject();
}
