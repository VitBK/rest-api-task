package jmp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String birthday;

    public UserResponseDto(UserRequestDto urd) {
        this.id = urd.getId();
        this.name = urd.getName();
        this.surname = urd.getSurname();
        this.birthday = urd.getBirthday();
    }

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.birthday = user.getBirthday().toString();
    }
}
