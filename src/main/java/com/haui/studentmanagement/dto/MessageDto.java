
package com.haui.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto extends BaseDto{
    private Long toAccount;
    
    private String detail;
    
    private Long timeMessage;
    
    private Long userId;
    
    private Long teacherId;
}
