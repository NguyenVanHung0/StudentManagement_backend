
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.TeacherDto;
import com.haui.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    
    @GetMapping("{id}")
    ResponseEntity<?> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }
    
    @GetMapping("")
    ResponseEntity<?> getListTeacher(){
        return ResponseEntity.ok(teacherService.getListTeacher());
    }
    
    @PostMapping("")
    ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.createTeacher(teacherDto));
    }
    
    @PutMapping("{id}")
    ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto){
        return ResponseEntity.ok(teacherService.updateTeacher(id, teacherDto));
    }
}
