package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO extends  DAO<Category, Integer>{

    Optional<Category> findOneCategory(Integer key);

    List<Category> findAllCategory();

    Optional<Category> findById(String id);
}

