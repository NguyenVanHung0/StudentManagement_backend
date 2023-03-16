
package com.haui.studentmanagement.service;

import com.haui.studentmanagement.dto.UserDto;
import java.util.List;


public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getListUser();
    UserDto getUserById(Long id);
    UserDto updateUser(Long id, UserDto userDto);
}
