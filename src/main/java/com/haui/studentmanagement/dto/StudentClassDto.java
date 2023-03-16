
package com.haui.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassDto {
    private Long id;
    
    private int year;
    
    private Long studentId;
    
    private Long classId;
}
