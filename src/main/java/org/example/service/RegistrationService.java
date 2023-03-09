package org.example.service;

import org.example.model.dto.request.RegisterRequestNewUserDto;
import org.example.model.dto.response.RegisterResponseNewUserDto;

public interface RegistrationService {

    RegisterResponseNewUserDto registerNewUser(RegisterRequestNewUserDto dto);
}
