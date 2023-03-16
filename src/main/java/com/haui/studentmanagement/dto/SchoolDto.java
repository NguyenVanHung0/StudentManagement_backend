
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
public class SchoolDto extends BaseDto{
    private String name;
    
    private String address;
    
    private String foundedYear;
    
    private List<Long> users;
    
    private List<Long> teachers;
}
