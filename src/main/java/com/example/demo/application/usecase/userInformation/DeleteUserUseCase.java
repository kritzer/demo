package com.example.demo.application.usecase.userInformation;

import com.example.demo.domain.user.model.UserInformation;
import com.example.demo.domain.user.repository.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserInformationRepository userRepository;
    private final GetUserUseCase getUserUseCase;

    public void removeUserByUserID(Long userID) {
        UserInformation userByUserInformationID = getUserUseCase.getUserByUserID(userID);
        userRepository.delete(userByUserInformationID);
    }
}
