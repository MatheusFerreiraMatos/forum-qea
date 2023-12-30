package br.mftech.projeto.qaforum.repository;

import br.mftech.projeto.qaforum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByCategoryName(String nameCategory);

}
