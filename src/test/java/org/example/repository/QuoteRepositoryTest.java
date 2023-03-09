package org.example.repository;

import org.example.model.entity.Quote;
import org.example.model.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class QuoteRepositoryTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private UserRepository userRepository;

    private static Quote quoteSaved;
    private static Quote quoteNew;

    @BeforeEach
    void setup(){
        User userSaved = userRepository.save(User.builder()
                .id(UUID.randomUUID())
                .name("Aaaaa")
                .password("Tyuio9)")
                .signUpDate(LocalDate.now())
                .build());

        quoteSaved = quoteRepository.save(Quote.builder()
                .id(UUID.randomUUID())
                .text("text")
                .postedBy(userSaved)
                .date(LocalDate.now())
                        .rating(0)
                .build());

        quoteNew = Quote.builder()
                .id(UUID.randomUUID())
                .text("text")
                .postedBy(userSaved)
                .date(LocalDate.now())
                .rating(0)
                .build();
    }

    @AfterEach
    public void destroyAll(){
        userRepository.deleteAll();
        quoteRepository.deleteAll();
    }
    @Test
    void returnTrueWhenSaveQuote(){
        quoteNew = quoteRepository.save(quoteNew);
        assertTrue(quoteRepository.findById(quoteNew.getId()).isPresent());
        assertEquals(quoteRepository.findById(quoteNew.getId()).orElseThrow(), quoteNew);
    }
    @Test
    void returnTrueIfQuoteExists(){
        List<Quote> quoteList = quoteRepository.findAll();
        assertTrue(quoteRepository.findById(quoteSaved.getId()).isPresent());
    }
    @Test
    void returnFalseWhenQuoteDeleted(){
        quoteRepository.delete(quoteSaved);
        assertFalse(quoteRepository.findById(quoteSaved.getId()).isPresent());
    }
}
