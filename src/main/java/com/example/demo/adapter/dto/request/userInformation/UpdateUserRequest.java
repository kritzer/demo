package com.example.demo.adapter.dto.request.userInformation;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long userID;
    private String firstName;
    private String LastName;
    private String firstNameEN;
    private String LastNameEN;
}
