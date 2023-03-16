
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.StudentClassDto;
import com.haui.studentmanagement.model.StudentClass;
import com.haui.studentmanagement.repository.StudentClassRepository;
import com.haui.studentmanagement.service.StudentClassService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassServiceImp implements StudentClassService{
    
    @Autowired
    StudentClassRepository studentClassRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public List<StudentClassDto> getListStudentClassByStudentId(Long studentId) {
        List<StudentClass> listStudentClass = studentClassRepository.getListStudentClassByStudentId(studentId);
        List<StudentClassDto> result = new ArrayList<>();
        if(listStudentClass == null){
            throw new NoSuchElementException("Khong tim thay lop hoc tuong ung voi hoc sinh");
        }
        for(StudentClass s : listStudentClass){
            result .add(mapper.toStudentClassDto(s));
        }
        
        return result;
    }

    @Override
    public List<StudentClassDto> getListStudentClassByClassId(Long classId) {
        List<StudentClass> listStudentClass = studentClassRepository.getListStudentClassByClassId(classId);
        List<StudentClassDto> result = new ArrayList<>();
        if(listStudentClass == null){
            throw new NoSuchElementException("Khong tim thay lop hoc tuong ung voi hoc sinh");
        }
        for(StudentClass s : listStudentClass){
            result .add(mapper.toStudentClassDto(s));
        }
        
        return result;
    }
    
}
