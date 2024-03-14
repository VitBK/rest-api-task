package jmp.servicerest;

import jmp.dto.UserRequestDto;
import jmp.dto.UserResponseDto;

import java.util.List;

public interface UserController {

    UserResponseDto createUser(UserRequestDto userDto);
    UserResponseDto updateUser(UserRequestDto userDto);
    void deleteUser(Long userId);
    UserResponseDto getUser(Long userId);
    List<UserResponseDto> getAllUser();

}
