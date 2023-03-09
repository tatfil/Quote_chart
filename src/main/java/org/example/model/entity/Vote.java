package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "vote")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name ="vote_id")
    private UUID id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    private Quote quote;
}
