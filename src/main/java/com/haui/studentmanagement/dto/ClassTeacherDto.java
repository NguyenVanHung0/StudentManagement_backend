
package com.haui.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassTeacherDto {
     private Long id;
    
    private int year;
    
    private Long classId;
    
    private Long teacherId;
}
