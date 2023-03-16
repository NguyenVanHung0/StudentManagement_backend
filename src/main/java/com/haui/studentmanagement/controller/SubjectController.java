
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.SubjectDto;
import com.haui.studentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subject")
public class SubjectController {
    
    @Autowired
    SubjectService subjectService;
    
    @GetMapping("{id}")
    ResponseEntity<?> getSubjectByIdAndYear(@PathVariable Long id){
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }
    
    @GetMapping("")
    ResponseEntity<?> getListSubject(){
        return ResponseEntity.ok(subjectService.getListSubject());
    }
    
    @PostMapping("")
    ResponseEntity<?> createSubject(@RequestBody SubjectDto subjectDto){
        return ResponseEntity.ok(subjectService.createSubject(subjectDto));
    }
}
