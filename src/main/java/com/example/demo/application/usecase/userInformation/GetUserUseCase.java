package com.example.demo.application.usecase.userInformation;

import com.example.demo.domain.user.model.UserInformation;
import com.example.demo.domain.user.repository.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserUseCase {
    private final UserInformationRepository userRepository;

    public UserInformation getUserByUserID(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }
}
