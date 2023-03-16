
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.SchoolDto;
import com.haui.studentmanagement.model.School;
import com.haui.studentmanagement.repository.SchoolRepository;
import com.haui.studentmanagement.service.SchoolService;
import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImp implements SchoolService{
    
    @Autowired
    SchoolRepository schoolRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public SchoolDto createSchool(SchoolDto schoolDto) {
        School school = mapper.toSchool(schoolDto);
        school.setCreatedDate(new Date());
        schoolRepository.save(school);
        return mapper.toSchoolDto(school);
    }

    @Override
    public SchoolDto getSchoolById(Long id) {
        School school = schoolRepository.findById(id).orElse(null);
        if(school == null){
            throw new NoSuchElementException("Khong tim thay truong");
        }
        
        return mapper.toSchoolDto(school);
    }
    
}
