
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
public class TeacherDto extends BaseDto{
    private String teacherName;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    private List<Long> classTeachers;
    
    private List<Long> messages;
    
    private Long subjectId;
    
    private Long schoolId;
    
    private List<Long> managementScores;
}
