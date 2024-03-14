package jmp.cloudserviceimpl;

import jmp.dto.Subscription;
import jmp.dto.SubscriptionRequestDto;
import jmp.dto.SubscriptionResponseDto;
import jmp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceServiceImpl {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserServiceImpl userService;

    @Transactional
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto) {
        User user = userService.findUser(subscriptionDto.getUserId());
        Subscription sub = Subscription.builder()
                .user(user)
                .startDate(LocalDate.now())
                .build();
        sub = subscriptionRepository.save(sub);
        return new SubscriptionResponseDto(sub.getId(), subscriptionDto.getUserId(), sub.getStartDate().toString());
    }

    @Transactional
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto) {
        Subscription sub = subscriptionRepository.findById(subscriptionDto.getId()).orElseThrow();
        User user = userService.findUser(subscriptionDto.getUserId());
        sub.setUser(user);
        subscriptionRepository.save(sub);
        return new SubscriptionResponseDto(sub);
    }

    @Transactional
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Transactional(readOnly = true)
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .map(SubscriptionResponseDto::new)
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        return subscriptionRepository.findAll().stream()
                .map(SubscriptionResponseDto::new)
                .toList();
    }
}
