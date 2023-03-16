package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.UserDto;
import com.haui.studentmanagement.model.School;
import com.haui.studentmanagement.model.Student;
import com.haui.studentmanagement.model.User;
import com.haui.studentmanagement.repository.SchoolRepository;
import com.haui.studentmanagement.repository.StudentRepository;
import com.haui.studentmanagement.repository.UserRepository;
import com.haui.studentmanagement.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Mapper mapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.toUser(userDto);
        user.setCreatedDate(new Date());
        School school = schoolRepository.findById(userDto.getSchoolId()).orElse(null);
        
        if (school == null) {
            throw new NoSuchElementException("Khong tim thay truong");
        }
        user.setSchool(school);
        userRepository.save(user);
        return mapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getListUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();
        
        for(User u : users){
            result.add(mapper.toUserDto(u));
        }
        
        return result;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new NoSuchElementException("Khong tim thay user");
        }
        
        return mapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new NoSuchElementException("Khong tim thay user");
        }
        
        user = mapper.toUser(user, userDto);
        user.setModifiedDate(new Date());
        userRepository.save(user);
        
        return mapper.toUserDto(user);
    }

}
