package com.example.demo.domain.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name = "first_Name_EN")
    private String firstNameEN;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "last_Name_EN")
    private String lastNameEN;

    @Column(name = "is_Disabled")
    @Builder.Default
    private Boolean isDisabled = false;
}
