package org.example.repository;

import org.example.model.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private static User userSaved;
    private static User userNew;

    @BeforeEach
    void setup(){
        userSaved = userRepository.save(User.builder()
                .id(UUID.randomUUID())
                .name("Aaaaa")
                .password("Tyuio9)")
                .signUpDate(LocalDate.now())
                .build());

        userNew = (User.builder()
                .id(UUID.randomUUID())
                .name("Bbbbb")
                .password("Tyuio9)")
                .signUpDate(LocalDate.now())
                .build());
    }
    @AfterEach
    public void destroyAll(){
        userRepository.deleteAll();
    }
    @Test
    void returnTrueWhenSaveUser(){
        userNew = userRepository.save(userNew);
        assertTrue(userRepository.findById(userNew.getId()).isPresent());
    }
    @Test
    void returnIsEmptyWhenDeleteUser(){
        userRepository.deleteById(userSaved.getId());
        assertTrue(userRepository.findById(userSaved.getId()).isEmpty());
    }
    @Test
    void returnTrueIfUserExists(){
        assertTrue(userRepository.findById(userSaved.getId()).isPresent());
    }
}
