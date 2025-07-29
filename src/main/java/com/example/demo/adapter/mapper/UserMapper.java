package com.example.demo.adapter.mapper;

import com.example.demo.adapter.dto.request.userInformation.CreateUserRequest;
import com.example.demo.adapter.dto.request.userInformation.UpdateUserRequest;
import com.example.demo.domain.user.model.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserInformation mapCreateUserRequestToUser(CreateUserRequest request);

    void updateUserRequestToUser(UpdateUserRequest request,@MappingTarget UserInformation userInformation);
}
