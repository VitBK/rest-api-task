package jmp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponseDto {

    private Long id;
    private Long userId;
    private String startDate;

    public SubscriptionResponseDto(Subscription sub) {
        this.id = sub.getId();
        this.userId = sub.getUser().getId();
        this.startDate = sub.getStartDate().toString();
    }
}
