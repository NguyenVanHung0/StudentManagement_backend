
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.SchoolDto;
import com.haui.studentmanagement.repository.StudentClassRepository;
import com.haui.studentmanagement.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentclass")
public class StudentClassController {
    @Autowired
    StudentClassService studentClassService;
    
    @GetMapping("{studentId}")
    ResponseEntity<?> getListStudentClassByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(studentClassService.getListStudentClassByStudentId(studentId));
    }
    
     @GetMapping("class/{classId}")
    ResponseEntity<?> getListStudentClassByClassId(@PathVariable Long classId){
        return ResponseEntity.ok(studentClassService.getListStudentClassByClassId(classId));
    }
}
