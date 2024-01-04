package br.mftech.projeto.qaforum.controller.dto.request;

import br.mftech.projeto.qaforum.model.Category;
import br.mftech.projeto.qaforum.model.Topic;
import br.mftech.projeto.qaforum.repository.CategoryRepository;

import br.mftech.projeto.qaforum.repository.TopicRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TopicRequest {

    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty
    private String message;
    @NotNull @NotEmpty
    private String nameCategory;

    public Topic convert(CategoryRepository repository) {
        Category category = repository.findByName(nameCategory);
        return new Topic(title, message, category);
    }

    public Topic update(Long id, TopicRepository topicRepository, CategoryRepository categoryRepository) {
        Topic topic = topicRepository.getReferenceById(id);
        Category category = categoryRepository.getReferenceById(topic.getCategory().getId());
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        topic.setCategory(category.update(topic.getCategory().getId(), categoryRepository));
        return topic;
    }
}