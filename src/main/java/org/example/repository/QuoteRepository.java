package org.example.repository;

import org.example.model.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {

    @Modifying
    @Query("UPDATE Quote q SET q.text = :text WHERE q.id = :id")
    int setQuoteTextById(@Param("text")String text,  @Param("id") UUID id);

    @Modifying
    @Query("UPDATE Quote q SET q.rating = :rating WHERE q.id = :id")
    int updateRating(@Param(value = "rating")Integer rating, @Param(value = "id") UUID id);

    Optional<Quote> findByText(String text);

 //   @Query(value = "SELECT * FROM Quote ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    @Query(value = "SELECT * FROM Quote WHERE id >= RAND() * " +
            "( SELECT MAX (id) FROM Quote ) " +
            "ORDER BY num_value LIMIT 1", nativeQuery = true)
    Quote getRandomQuote();

    @Query(value = "SELECT * FROM Quote ORDER BY rating asc LIMIT 10 ", nativeQuery = true)
    List<Quote> getTop10Quotes();

    @Query(value = "SELECT * FROM Quote ORDER BY rating desc LIMIT 10 ", nativeQuery = true)
    List<Quote> getWorst10Quotes();

}
