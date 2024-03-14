package jmp.cloudserviceimpl;

import jmp.dto.User;
import jmp.dto.UserRequestDto;
import jmp.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .name(userRequestDto.getName())
                    .surname(userRequestDto.getSurname())
                .birthday(LocalDate.parse(userRequestDto.getBirthday()))
                .build();
        user = userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getName(), user.getSurname(), userRequestDto.getBirthday());
    }

    @Transactional
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId()).orElseThrow();
        user.setName(userRequestDto.getName());
        user.setName(userRequestDto.getSurname());
        user.setBirthday(LocalDate.parse(userRequestDto.getBirthday()));
        userRepository.save(user);
        return new UserResponseDto(userRequestDto);
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        return userRepository.findById(userId)
                .map(UserResponseDto::new)
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow();
    }
}
