package br.mftech.projeto.qaforum.repository;

import br.mftech.projeto.qaforum.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String nameCategory);
}
