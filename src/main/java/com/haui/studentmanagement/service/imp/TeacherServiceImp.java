
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.TeacherDto;
import com.haui.studentmanagement.model.School;
import com.haui.studentmanagement.model.Subject;
import com.haui.studentmanagement.model.Teacher;
import com.haui.studentmanagement.repository.SchoolRepository;
import com.haui.studentmanagement.repository.SubjectRepository;
import com.haui.studentmanagement.repository.TeacherRepository;
import com.haui.studentmanagement.service.TeacherService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp implements TeacherService{
    
    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    SchoolRepository schoolRepository;
    
    @Autowired
    SubjectRepository subjectRepository;
    
    @Autowired 
    Mapper mapper;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = mapper.toTeacher(teacherDto);
        teacher.setCreatedDate(new Date());
        School school = schoolRepository.findById(teacherDto.getSchoolId()).orElse(null);
        Subject subject = subjectRepository.findById(teacherDto.getSubjectId()).orElse(null);
        
        if(school == null){
            throw new NoSuchElementException("Khong tim thay truong");
        }
        if(subject == null){
            throw new NoSuchElementException("Khong tim thay truong");
        }
        teacher.setSchool(school);
        teacher.setSubject(subject);
        teacherRepository.save(teacher);
        
        return mapper.toTeacherDto(teacher);
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(teacher == null){
            throw new NoSuchElementException("Khong tim thay giao vien");
        }
        
        return mapper.toTeacherDto(teacher);
    }

    @Override
    public List<TeacherDto> getListTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDto> result = new ArrayList<>();
        if(teachers == null){
            throw new NoSuchElementException("Khong tim thay giao vien");
        }
        for(Teacher t : teachers){
            result.add(mapper.toTeacherDto(t));
        }
        
        return result;
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {
        Teacher oldTeacher = teacherRepository.findById(id).orElse(null);
        
        if(oldTeacher == null){
            throw new NoSuchElementException("Khong tim thay giao vien");
        }
        oldTeacher = mapper.toTeacher(oldTeacher, teacherDto);
        oldTeacher.setModifiedDate(new Date());
        teacherRepository.save(oldTeacher);
        
        return mapper.toTeacherDto(oldTeacher);
    }
    
}
