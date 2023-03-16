package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.StudentDto;
import com.haui.studentmanagement.model.Student;
import com.haui.studentmanagement.model.User;
import com.haui.studentmanagement.repository.StudentRepository;
import com.haui.studentmanagement.repository.UserRepository;
import com.haui.studentmanagement.service.StudentService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Random random = new Random();
        Student student = mapper.toStudent(studentDto);
        student.setCreatedDate(new Date());
        Student studentByCode = new Student();
        String code;
        do {
            code = random.nextInt(1000) + "haui" + random.nextInt(1000);
            studentByCode = studentRepository.getStudentByCode(code);
        } while (studentByCode != null);
        student.setCode(code);
        if (studentDto.getUserId() != null) {
            User user = userRepository.findById(studentDto.getUserId()).orElse(null);
            if (user == null) {
                throw new NoSuchElementException("Khong tim thay user");
            }
            student.setUser(user);
        }
        studentRepository.save(student);
        return mapper.toStudentDto(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        return mapper.toStudentDto(student);
    }

    @Override
    public List<StudentDto> getListStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> result = new ArrayList<>();
        if (students == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        for (Student s : students) {
            result.add(mapper.toStudentDto(s));
        }

        return result;
    }

    @Override
    public StudentDto getStudentByUserId(Long id) {
        Student student = studentRepository.getStudentByUserId(id);
        if (student == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        return mapper.toStudentDto(student);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student studentOld = studentRepository.findById(id).orElse(null);
        if (studentOld == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        studentOld = mapper.toStudent(studentOld, studentDto);
        studentOld.setModifiedDate(new Date());
        User user = userRepository.findById(studentDto.getUserId()).orElse(null);
        if (user == null) {
            throw new NoSuchElementException("Khong tim thay user");
        }
        studentOld.setUser(user);
        studentRepository.save(studentOld);
        return mapper.toStudentDto(studentOld);
    }

    @Override
    public StudentDto getStudentByCode(String code) {
        Student student = studentRepository.getStudentByCode(code);
        if (student == null) {
            throw new NoSuchElementException("Khong tim thay hoc sinh");
        }
        return mapper.toStudentDto(student);
    }

}
