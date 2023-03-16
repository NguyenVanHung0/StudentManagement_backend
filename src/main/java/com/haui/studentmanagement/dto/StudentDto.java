
package com.haui.studentmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto extends BaseDto{
    private String name;
    
    private Date birthDate;
    
    private String address;
    
    private String code;
    
    private String gender;
    
    private Long userId;
    
    private List<Long> managementScores;
    
    private List<Long> studentSubjects;
    
    private List<Long> studentClass;
}
