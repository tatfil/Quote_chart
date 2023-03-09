package org.example.mapper;

import org.example.model.dto.response.RegisterResponseNewUserDto;
import org.example.model.entity.User;

public interface RegistrationMapper {
    RegisterResponseNewUserDto map(User user);
}
