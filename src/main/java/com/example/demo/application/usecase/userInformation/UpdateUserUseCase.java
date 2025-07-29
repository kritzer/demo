package com.example.demo.application.usecase.userInformation;

import com.example.demo.adapter.dto.request.userInformation.UpdateUserRequest;
import com.example.demo.domain.user.model.UserInformation;
import com.example.demo.domain.user.repository.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.adapter.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserInformationRepository userRepository;
    private final GetUserUseCase getUserUseCase;

    public UserInformation updateUser(UpdateUserRequest updateUserRequest) {
        UserInformation userInformation = getUserUseCase.getUserByUserID(updateUserRequest.getUserID());
        USER_MAPPER.updateUserRequestToUser(updateUserRequest, userInformation);
        return userRepository.save(userInformation);
    }
}
