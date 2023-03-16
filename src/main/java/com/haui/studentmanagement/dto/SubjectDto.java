
package com.haui.studentmanagement.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto extends BaseDto{
    private String name;
    
    private List<Long> studentSubjects;
    
    private List<Long> managementScore;
    
    private List<Long> teachers;
}
