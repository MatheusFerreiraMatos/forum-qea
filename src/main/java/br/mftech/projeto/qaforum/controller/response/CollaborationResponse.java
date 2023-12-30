package br.mftech.projeto.qaforum.controller.response;

import br.mftech.projeto.qaforum.model.Collaboration;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CollaborationResponse {

    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String author;

    public CollaborationResponse(Collaboration collaboration) {
        this.id = collaboration.getId();
        this.message = collaboration.getMessage();
        this.creationDate = collaboration.getCreationDate();
        this.author = collaboration.getAuthor().getFirstName();
    }

}
