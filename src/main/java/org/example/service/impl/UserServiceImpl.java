package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.exception.DuplicateUserException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User dto) {

        User user = User.builder()
                .name(dto.getName())
       //         .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .password(dto.getPassword())
                .password(dto.getPassword())
                .signUpDate(LocalDate.now())
                .build();

        Optional<User> savedUser = userRepository.findByName(user.getName());
        if(savedUser.isPresent()){
            throw new DuplicateUserException();
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }
}
