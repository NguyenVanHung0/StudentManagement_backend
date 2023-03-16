
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
public class UserDto extends BaseDto{
    private String userName;
    
    private String password;
    
    private String email;
    
    private String gender;
    
    private Long defaultStudent;
    
    private Long schoolId;
    
    private List<Long> students;
    
    private List<Long> message;
}
