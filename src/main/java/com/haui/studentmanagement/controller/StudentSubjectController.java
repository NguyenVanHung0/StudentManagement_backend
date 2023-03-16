
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentsubject")
public class StudentSubjectController {
    @Autowired
    StudentSubjectService studentSubjectService;
    
    @GetMapping("")
    ResponseEntity<?> getStudentSubjectByStudentId(@RequestParam(name = "studentId") Long studentId, @RequestParam(name = "year") int year){
        return ResponseEntity.ok(studentSubjectService.getStudentSubjectByStudentIdAndYear(studentId, year));
    }
}
