
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.ClassTeacherDto;
import com.haui.studentmanagement.model.ClassTeacher;
import com.haui.studentmanagement.repository.ClassTeacherRepository;
import com.haui.studentmanagement.service.ClassTeacherService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassTeacherServiceImp implements ClassTeacherService{

    @Autowired
    Mapper mapper;
    
    @Autowired
    ClassTeacherRepository classTeacherRepository;
    
    @Override
    public List<ClassTeacherDto> getClassTeacherByTeacherId(Long id) {
        List<ClassTeacher> classTeachers = classTeacherRepository.getClassTeacherByTeacherId(id);
        List<ClassTeacherDto> result = new ArrayList<>();
        if(classTeachers == null){
            throw new NoSuchElementException("Khong tim thay lop co id giao vien da cho");
        }
        
        for(ClassTeacher c : classTeachers){
            result.add(mapper.toClassTeacherDto(c));
        }
        
        return result;
    }

    @Override
    public List<ClassTeacherDto> getClassTeacherByTeacherIdAndYear(Long teacherId, int year) {
        List<ClassTeacher> classTeacchers = classTeacherRepository.getClassTeacherByTeacherIdAndYear(teacherId, year);
        List<ClassTeacherDto> result = new ArrayList<>();
        if(classTeacchers == null){
            throw new NoSuchElementException("Khong tim thay lop co id giao vien");
        }
        for(ClassTeacher c : classTeacchers){
            result.add(mapper.toClassTeacherDto(c));
        }
        
        return result;
    }
    
    
}
