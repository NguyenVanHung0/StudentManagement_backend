
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.StudentDto;
import com.haui.studentmanagement.service.StudentService;
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
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @GetMapping("")
    ResponseEntity<?> getListStudent(){
        return ResponseEntity.ok(studentService.getListStudent());
    }
    
    @GetMapping("{id}")
    ResponseEntity<?> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    
    @GetMapping("user/{id}")
    ResponseEntity<?> getStudentByUserId(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentByUserId(id));
    }
    
    @GetMapping("code/{code}")
    ResponseEntity<?> getStudentByCode(@PathVariable String code){
        return ResponseEntity.ok(studentService.getStudentByCode(code));
    }
    
    @PostMapping("")
    ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }
    
    @PutMapping("{id}")
    ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.updateStudent(id, studentDto));
    }
}
