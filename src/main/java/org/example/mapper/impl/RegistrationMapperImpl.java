package org.example.mapper.impl;

import org.example.mapper.RegistrationMapper;
import org.example.model.dto.response.RegisterResponseNewUserDto;
import org.example.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapperImpl implements RegistrationMapper {

    @Override
    public RegisterResponseNewUserDto map(User user) {
        return RegisterResponseNewUserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .dateRegistration(user.getSignUpDate())
                .build();

    }
}
