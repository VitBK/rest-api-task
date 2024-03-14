package jmp.cloudserviceimpl;

import jmp.dto.UserRequestDto;
import jmp.dto.UserResponseDto;
import jmp.servicerest.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserServiceImpl userService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    @PutMapping
    public UserResponseDto updateUser(@RequestBody UserRequestDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @Override
    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @Override
    @GetMapping
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUsers();
    }
}
