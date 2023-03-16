
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.MessageDto;
import com.haui.studentmanagement.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    MessageService messageService;
    
    @GetMapping("user/{userId}")
    ResponseEntity<?> getListMessageByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(messageService.getListMessageByUserId(userId));
    }
    
    @GetMapping("teacher/{teacherId}")
    ResponseEntity<?> getListMessageByTeacherId(@PathVariable Long teacherId){
        return ResponseEntity.ok(messageService.getListMessageByTeacherId(teacherId));
    }
    
    @GetMapping("toaccount/{toAccount}")
    ResponseEntity<?> getListMessageByToAccount(@PathVariable Long toAccount){
        return ResponseEntity.ok(messageService.getListMessageByToAccount(toAccount));
    }
    
    @PostMapping("")
    ResponseEntity<?> createMessage(@RequestBody MessageDto createMessage){
        return ResponseEntity.ok(messageService.createMessage(createMessage));
    }
}
