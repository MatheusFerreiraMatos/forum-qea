package br.mftech.projeto.qaforum.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Collaboration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Topic topic;
    private LocalDateTime creationDate;
    @ManyToOne
    private Member author;
    private Boolean solution = false;
}
