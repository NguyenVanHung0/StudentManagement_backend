
package com.haui.studentmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "management_score")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagementScore extends Base{
    
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
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clasz;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
