package com.example.demo.application.usecase.userInformation;

import com.example.demo.adapter.dto.request.userInformation.CreateUserRequest;
import com.example.demo.domain.user.model.UserInformation;
import com.example.demo.domain.user.repository.UserInformationRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.adapter.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserInformationRepository userRepository;

    public UserInformation createUser(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(String.format("User with email %s already exists", request.getEmail()));
        }

        UserInformation userInformation = USER_MAPPER.mapCreateUserRequestToUser(request);
        userRepository.save(userInformation);

        return userInformation;
    }
}
