package br.mftech.projeto.qaforum.controller;

import br.mftech.projeto.qaforum.controller.request.TopicRequest;
import br.mftech.projeto.qaforum.controller.response.TopicResponse;
import br.mftech.projeto.qaforum.model.Topic;
import br.mftech.projeto.qaforum.repository.CategoryRepository;
import br.mftech.projeto.qaforum.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public TopicController(TopicRepository topicRepository, CategoryRepository categoryRepository) {
        this.topicRepository = topicRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public Page<TopicResponse> list(@RequestParam(required = false) String nameCategory,
                                    @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        if (nameCategory == null) {
            Page<Topic> topics = topicRepository.findAll(pageable);
            return TopicResponse.convert(topics);
        } else {
            Page<Topic> topics = topicRepository.findByCategoryName(nameCategory, pageable);
            return TopicResponse.convert(topics);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicResponse> register(@RequestBody @Valid TopicRequest topicRequest, UriComponentsBuilder uriBuilder) {
        Topic topic = topicRequest.convert(categoryRepository);
        topicRepository.save(topic);

        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicResponse(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> TopicById(@PathVariable Long id) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new TopicResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicResponse> update(@PathVariable Long id, @RequestBody @Valid TopicRequest topicRequest) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()) {
            Topic topic = topicRequest.update(id, topicRepository, categoryRepository);
            return ResponseEntity.ok(new TopicResponse(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
