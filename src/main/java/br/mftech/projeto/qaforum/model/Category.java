package br.mftech.projeto.qaforum.model;

import br.mftech.projeto.qaforum.repository.CategoryRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category update(Long id, CategoryRepository categoryRepository) {
        Category category = categoryRepository.getReferenceById(id);
        category.setName(this.name);
        //Lógica para consultar e verificar se tem na base, caso não tenha cadastre, talvez um ENUM.
        return category;
    }
}
