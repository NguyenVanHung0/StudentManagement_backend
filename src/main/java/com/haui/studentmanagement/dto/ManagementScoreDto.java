package com.haui.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagementScoreDto extends BaseDto {

    private float diemHeSo1Ky1;
    
    private float diemHeSo2Ky1;
    
    private float diemHocKy1;
    
    private float diemHeSo1Ky2;
    
    private float diemHeSo2Ky2;
    
    private float diemHocKy2;

    private float avgScore;

    private String rank;

    private String commentInClass;

    private String commentInTest;
    
    private int year;

    private Long subjectId;

    private Long studentId;

    private Long classId;

    private Long teacherId;
}
