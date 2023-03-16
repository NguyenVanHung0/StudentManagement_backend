package com.haui.studentmanagement.controller;

import com.haui.studentmanagement.dto.ManagementScoreDto;
import com.haui.studentmanagement.service.ManagementScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("managementscore")
public class ManagementScoreController {

    @Autowired
    ManagementScoreService managementScoreService;

    @GetMapping("")
    ResponseEntity<?> getManagementScoreByStudentClassId(@RequestParam(name = "studentId") Long studentId, @RequestParam(name = "classId") Long classId) {
        return ResponseEntity.ok(managementScoreService.getManagementScoreByStudentClassId(studentId, classId));
    }

    @GetMapping("subject")
    ResponseEntity<?> getManagementScoreBySubjectStudentClassId(@RequestParam(name = "studentId") Long studentId, @RequestParam(name = "subjectId") Long subjectId, @RequestParam(name = "classId") Long classId) {
        return ResponseEntity.ok(managementScoreService.getManagementScoreBySubjectStudentClassId(studentId, subjectId, classId));
    }

    @GetMapping("teacherclassyear")
    ResponseEntity<?> getManagementScoreByTeacherClassIdAndyear(@RequestParam(name = "teacherid") Long teacherId, @RequestParam(name = "classId") Long classId, @RequestParam(name = "year") int year) {
        return ResponseEntity.ok(managementScoreService.getManagementScoreByTeacherClassIdAndyear(teacherId, classId, year));
    }

    @PostMapping("")
    ResponseEntity<?> createManagementScore(@RequestBody ManagementScoreDto managementScoreDto) {
        return ResponseEntity.ok(managementScoreService.createManagementScore(managementScoreDto));
    }
    
    @PutMapping("{id}")
    ResponseEntity<?> updateManagementScore(@PathVariable Long id, @RequestBody ManagementScoreDto managementScoreDto) {
        return ResponseEntity.ok(managementScoreService.updateManagementScore(id, managementScoreDto));
    }
}
