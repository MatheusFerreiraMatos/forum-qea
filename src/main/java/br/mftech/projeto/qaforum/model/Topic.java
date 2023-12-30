package br.mftech.projeto.qaforum.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopic status = StatusTopic.NOT_ANSWERED;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Member author;
    @OneToMany(mappedBy = "topic")
    private List<Collaboration> response = new ArrayList<>();

    public Topic(String title, String message, Category category) {
        this.title = title;
        this.message = message;
        this.category = category;
    }
}