package jmp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;

}
