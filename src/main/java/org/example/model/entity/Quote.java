package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "quote")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name ="quote_id")
    private UUID id;
    private String text;
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User postedBy;

    private Integer rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quote")
    private Set<Vote> votes;


}
