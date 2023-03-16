
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.SubjectDto;
import com.haui.studentmanagement.model.Subject;
import com.haui.studentmanagement.repository.SubjectRepository;
import com.haui.studentmanagement.service.SubjectService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImp implements SubjectService{
    
    @Autowired
    SubjectRepository subjectRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = mapper.toSubject(subjectDto);
        subject.setCreatedDate(new Date());
        subjectRepository.save(subject);
        
        return mapper.toSubjectDto(subject);
    }

    @Override
    public SubjectDto getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        if(subject == null){
            throw new NoSuchElementException("Khong tim thay mon hoc");
        }
        return mapper.toSubjectDto(subject);
    }

    @Override
    public List<SubjectDto> getListSubject() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDto> result = new ArrayList<>();
        
        if(subjects != null){
            for(Subject s : subjects){
                result.add(mapper.toSubjectDto(s));
            }
        }
        
        return result;
    }
    
}
