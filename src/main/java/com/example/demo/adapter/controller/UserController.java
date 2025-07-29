package com.example.demo.adapter.controller;

import com.example.demo.adapter.dto.request.userInformation.CreateUserRequest;
import com.example.demo.adapter.dto.request.userInformation.UpdateUserRequest;
import com.example.demo.application.usecase.userInformation.CreateUserUseCase;
import com.example.demo.application.usecase.userInformation.DeleteUserUseCase;
import com.example.demo.application.usecase.userInformation.GetUserUseCase;
import com.example.demo.application.usecase.userInformation.UpdateUserUseCase;
import com.example.demo.domain.user.model.UserInformation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.adapter.constant.ApiConstants.API_USER_V_1;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_USER_V_1)
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUser;
    private final GetUserUseCase getUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @GetMapping("/{userID}")
    public ResponseEntity<?> getUserByUserID(@PathVariable Long userID) {
        UserInformation userInformationByID = getUserUseCase.getUserByUserID(userID);
        return ResponseEntity.ok(userInformationByID);
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<?> deleteUserByID(@PathVariable Long userID) {
        deleteUserUseCase.removeUserByUserID(userID);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        UserInformation newUserInformation = createUserUseCase.createUser(createUserRequest);
        return ResponseEntity.ok(newUserInformation);
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) {
        UserInformation newUserInformation = updateUser.updateUser(updateUserRequest);
        return ResponseEntity.ok(newUserInformation);
    }
}
