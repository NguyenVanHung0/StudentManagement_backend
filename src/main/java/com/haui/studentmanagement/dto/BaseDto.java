
package com.haui.studentmanagement.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    private Long id;
    
    private String createdBy;
    
    private Date createdDate;
    
    private String modifiedBy;
    
    private Date modifiedDate;
}
