
package com.haui.studentmanagement.service.imp;

import com.haui.studentmanagement.convert.Mapper;
import com.haui.studentmanagement.dto.MessageDto;
import com.haui.studentmanagement.model.Message;
import com.haui.studentmanagement.model.Teacher;
import com.haui.studentmanagement.model.User;
import com.haui.studentmanagement.repository.MessageRepository;
import com.haui.studentmanagement.repository.TeacherRepository;
import com.haui.studentmanagement.repository.UserRepository;
import com.haui.studentmanagement.service.MessageService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService{
    
    @Autowired
    MessageRepository messageRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    Mapper mapper;
    
    @Override
    public MessageDto createMessage(MessageDto messageDto) {
        Message message = mapper.toMessage(messageDto);
        message.setCreatedDate(new Date());
        message.setTimeMessage(new Date().getTime());
        if(messageDto.getUserId() != null){
            User user = userRepository.findById(messageDto.getUserId()).orElse(null);
            if(user == null){
                throw new NoSuchElementException("Khong tim thay nguoi dung");
            }
            message.setUser(user);
        }
        if(messageDto.getTeacherId()!= null){
            Teacher teacher = teacherRepository.findById(messageDto.getTeacherId()).orElse(null);
            if(teacher == null){
                throw new NoSuchElementException("Khong tim thay giao vien");
            }
            message.setTeacher(teacher);
        }
        messageRepository.save(message);
        
        return mapper.toMessageDto(message);
    }

    @Override
    public List<MessageDto> getListMessageByUserId(Long userId) {
        List<Message> messages = messageRepository.getListMessageByUserId(userId);
        List<MessageDto> result = new ArrayList<>();
        if(messages != null){
            for(Message m : messages){
                result.add(mapper.toMessageDto(m));
            }
        }
        
        return result;
    }

    @Override
    public List<MessageDto> getListMessageByTeacherId(Long teacherId) {
        List<Message> messages = messageRepository.getListMessageByTeacherId(teacherId);
        List<MessageDto> result = new ArrayList<>();
        if(messages != null){
            for(Message m : messages){
                result.add(mapper.toMessageDto(m));
            }
        }
        
        return result;
    }

    @Override
    public List<MessageDto> getListMessageByToAccount(Long toAccount) {
        List<Message> messages = messageRepository.getListMessageByToAccount(toAccount);
        List<MessageDto> result = new ArrayList<>();
        if(messages != null){
            for(Message m : messages){
                result.add(mapper.toMessageDto(m));
            }
        }
        
        return result;
    }
    
}
