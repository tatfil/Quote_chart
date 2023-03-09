package org.example;

import org.example.repository.QuoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QuoteChatApplication.class, properties = { "spring.jpa.defer-datasource-initialization=true", "spring.jpa.hibernate.ddl-auto=none"})
@Sql(value = {"classpath:db/create_schema.sql", "classpath:db/populate_schema.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class SpringBootInitialLoadIntegrationTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Test
    public void testLoadDataForTestClass() {
        assertEquals(2, quoteRepository.findAll().size());
    }
}

