package jmp.serviceapi;

import jmp.dto.SubscriptionRequestDto;
import jmp.dto.SubscriptionResponseDto;

import java.util.List;

public interface ServiceController {

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto);
    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto);
    void deleteSubscription(Long subscriptionId);
    SubscriptionResponseDto getSubscription(Long subscriptionId);
    List<SubscriptionResponseDto> getAllSubscription();

}
