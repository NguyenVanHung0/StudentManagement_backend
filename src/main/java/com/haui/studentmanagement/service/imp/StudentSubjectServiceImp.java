
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.StudentSubjectDto;
import com.haui.studentmanagement.model.StudentSubject;
import com.haui.studentmanagement.repository.StudentSubjectRepository;
import com.haui.studentmanagement.service.StudentSubjectService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectServiceImp implements StudentSubjectService{
    
    @Autowired
    StudentSubjectRepository studentSubjectRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public List<StudentSubjectDto> getStudentSubjectByStudentIdAndYear(Long studentId, int year) {
        List<StudentSubject> listStudentSubject = studentSubjectRepository.getListStudentSubjectByIdAndYear(studentId, year);
        List<StudentSubjectDto> result = new ArrayList<>();
        if(listStudentSubject == null){
            throw new NoSuchElementException("Khong tim thay mon hoc khop voi hoc sinh nay");
        }
        
        for(StudentSubject s : listStudentSubject){
            result.add(mapper.toStudentSubjectDto(s));
        }
        
        return result;
    }
    
}
