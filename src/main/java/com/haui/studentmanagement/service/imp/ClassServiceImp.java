
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.ClassDto;
import com.haui.studentmanagement.model.Class;
import com.haui.studentmanagement.repository.ClassRepository;
import com.haui.studentmanagement.service.ClassService;
import java.util.Date;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImp implements ClassService{
    
    @Autowired
    ClassRepository classRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public ClassDto createClass(ClassDto classDto) {
        Class clasz = mapper.toClass(classDto);
        clasz.setCreatedDate(new Date());
        classRepository.save(clasz);
        
        return mapper.toClassDto(clasz);
    }

    @Override
    public ClassDto getClassById(Long id) {
        Class clasz = classRepository.findById(id).orElse(null);
        if(clasz == null){
            throw new NoSuchElementException("Khong tim thay lop");
        }
        return mapper.toClassDto(clasz);
    }
    
}
