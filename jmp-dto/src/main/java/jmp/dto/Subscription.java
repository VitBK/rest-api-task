package jmp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Subscription {

    private Long id;
    private User user;
    private LocalDate startDate;

}
