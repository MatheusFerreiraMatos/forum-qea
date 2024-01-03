package br.mftech.projeto.qaforum.controller.response;

import br.mftech.projeto.qaforum.model.Collaboration;
import br.mftech.projeto.qaforum.model.StatusTopic;
import br.mftech.projeto.qaforum.model.Topic;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicResponse {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String author;
    private StatusTopic status;
    private List<CollaborationResponse> answers;

    public TopicResponse(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.author = topic.getAuthor().getFirstName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getResponse().stream().map(CollaborationResponse::new).collect(Collectors.toList()));
    }

    public static Page<TopicResponse> convert(Page<Topic> topics) {
        return topics.map(TopicResponse::new);
    }
}
