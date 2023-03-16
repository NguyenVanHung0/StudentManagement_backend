
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.service.ClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classteacher")
public class ClassTeacherController {
    
    @Autowired
    ClassTeacherService ClassTeacherService;
    
    @GetMapping("{id}")
    ResponseEntity<?> getClassTeacherByTeacherId(@PathVariable Long id){
        return ResponseEntity.ok(ClassTeacherService.getClassTeacherByTeacherId(id));
    }
    
    @GetMapping("teacheryear")
    ResponseEntity<?> getClassTeacherByTeacherIdAndYear(@RequestParam(name = "teacherid") Long teacherId, @RequestParam(name = "year") int year){
        return ResponseEntity.ok(ClassTeacherService.getClassTeacherByTeacherIdAndYear(teacherId, year));
    }
}
