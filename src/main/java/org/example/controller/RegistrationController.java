package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.model.dto.response.RegisterResponseNewUserDto;
import org.example.model.dto.request.RegisterRequestNewUserDto;
import org.example.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @Operation(summary = "Register new user")
    @PostMapping("/user/new")
    public ResponseEntity<RegisterResponseNewUserDto> registerNewUser(@Valid @RequestBody RegisterRequestNewUserDto
                                                                                  registerRequestNewUserDto) {
        RegisterResponseNewUserDto registerResponseNewUserDto = registrationService
                .registerNewUser(registerRequestNewUserDto);

        return ResponseEntity.ok().body(registerResponseNewUserDto);
    }
}
