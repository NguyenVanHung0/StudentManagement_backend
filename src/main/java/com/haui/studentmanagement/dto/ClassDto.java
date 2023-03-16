
package com.haui.studentmanagement.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDto extends BaseDto{
    private String name;
    
    private List<Long> studentClasss;
    
    private List<Long> managementScores;
    
    private List<Long> classTeachers;
}
