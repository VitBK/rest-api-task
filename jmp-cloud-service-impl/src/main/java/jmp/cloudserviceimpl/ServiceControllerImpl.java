package jmp.cloudserviceimpl;

import jmp.dto.SubscriptionRequestDto;
import jmp.dto.SubscriptionResponseDto;
import jmp.serviceapi.ServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class ServiceControllerImpl implements ServiceController {

    @Autowired
    private ServiceServiceImpl serviceService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        return serviceService.createSubscription(subscriptionDto);
    }

    @Override
    @PutMapping
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        return serviceService.updateSubscription(subscriptionDto);
    }

    @Override
    @DeleteMapping("/{subscriptionId}")
    public void deleteSubscription(@PathVariable("subscriptionId") Long subscriptionId) {
        serviceService.deleteSubscription(subscriptionId);
    }

    @Override
    @GetMapping("/{subscriptionId}")
    public SubscriptionResponseDto getSubscription(@PathVariable("subscriptionId") Long subscriptionId) {
        return serviceService.getSubscription(subscriptionId);
    }

    @Override
    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscription() {
        return serviceService.getAllSubscriptions();
    }
}
