package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.request.RegisterRequestNewUserDto;
import org.example.model.dto.response.RegisterResponseNewUserDto;
import org.example.mapper.RegistrationMapper;
import org.example.model.entity.User;
import org.example.service.RegistrationService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;

    private final RegistrationMapper registrationMapper;
    @Override
    public RegisterResponseNewUserDto registerNewUser(RegisterRequestNewUserDto dto) {
        RegisterResponseNewUserDto registeredUserDto;
        User user = User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .signUpDate(LocalDate.now())
                .build();
        User userSaved = userService.saveUser(user);
        registeredUserDto = registrationMapper.map(userSaved);
        return registeredUserDto;
    }
}
