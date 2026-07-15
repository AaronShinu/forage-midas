package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BalanceController {
    
    private final UserRepository userRepository;

    private BalanceController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam Long userId) {
        Optional<UserRecord> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return new Balance(0);
        }

        return new Balance(user.get().getBalance());
    }
    
}
