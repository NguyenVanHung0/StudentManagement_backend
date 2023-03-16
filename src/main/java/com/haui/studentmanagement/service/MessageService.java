
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.MessageDto;
import java.util.List;


public interface MessageService {
    MessageDto createMessage(MessageDto messageDto);
    List<MessageDto> getListMessageByUserId(Long userId);
    List<MessageDto> getListMessageByTeacherId(Long teacherId);
    List<MessageDto> getListMessageByToAccount(Long toAccount);
}
