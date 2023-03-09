package org.example.service;

import org.example.model.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User saveUser(User user);

    Optional<User> findById(UUID userId);

}
