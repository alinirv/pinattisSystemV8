package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;

import java.util.List;
import java.util.Optional;

public class ListCategoriesUseCase {
    private CategoryDAO categoryDAO;

    public ListCategoriesUseCase(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    /**
     * Recupera uma categoria pelo seu ID.
     *
     * @param id O ID da categoria a ser recuperada.
     * @return Um Optional contendo a categoria encontrada ou vazio se não encontrada.
     * @throws IllegalArgumentException se o ID for nulo.
     */
    public Optional<Category> findOneCategory(Integer id) {
        if (id == null) {
            // Lança uma exceção se o ID for nulo
            throw new IllegalArgumentException("ID can not be null");
        }
        return categoryDAO.findOneCategory(id);
    }

    /**
     * Recupera todas as categorias.
     *
     * @return Uma lista contendo todas as categorias.
     */
    public List<Category> findAllCategory() {
        return categoryDAO.findAllCategory();
    }
}
