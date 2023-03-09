package org.example.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.controller.RegistrationController;
import org.example.model.dto.request.RegisterRequestNewUserDto;
import org.example.model.entity.User;

import org.example.service.impl.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

    @Mock
    private RegistrationServiceImpl registrationService;

    @InjectMocks
    private RegistrationController registrationController;

    MockMvc mockMvc;

    ObjectMapper objectMapper;



    private static User user;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();

        mockMvc = MockMvcBuilders
                .standaloneSetup(registrationController)
                .build();

        user = User.builder()
                .id(UUID.randomUUID())
                .name("Aaaaa")
                .password("Tyuio9)")
                .signUpDate(LocalDate.now())
                .build();

    }

    @Test
    void registerUser() throws Exception {
        RegisterRequestNewUserDto request = new RegisterRequestNewUserDto(user.getName(), user.getPassword());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post("/registration/user/new")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request));

        mockMvc.perform(mockRequest)
                .andDo(print())
                .andExpect(status().isOk());
    }

}
