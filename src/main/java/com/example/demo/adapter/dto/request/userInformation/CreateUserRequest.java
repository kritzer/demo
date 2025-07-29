package com.example.demo.adapter.dto.request.userInformation;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String firstNameEN;
    private String lastNameEN;
}
