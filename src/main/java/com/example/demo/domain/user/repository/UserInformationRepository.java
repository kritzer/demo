package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    boolean existsByEmail(String email);
}
