
package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.SchoolDto;
import com.haui.studentmanagement.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("school")
public class SchoolController {
    
    @Autowired
    SchoolService schoolService;
    
    @GetMapping("{id}")
    ResponseEntity<?> getSchoolById(@PathVariable Long id){
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }
    
    @PostMapping("")
    ResponseEntity<?> createSchool(@RequestBody SchoolDto schoolDto){
        return ResponseEntity.ok(schoolService.createSchool(schoolDto));
    }
}
