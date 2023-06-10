package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateCategoryUseCase {
    private CategoryDAO categoryDAO;

    public UpdateCategoryUseCase(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    /**
     * Insere uma nova categoria.
     *
     * @param category A categoria a ser inserida.
     * @return O ID da categoria inserida.
     * @throws IllegalArgumentException se houver erros de validação na categoria.
     */

    public Integer insert(Category category) {
        // Cria uma instância do validador para a entrada da categoria
        Validator<Category> validator = new CategoryInputRequestValidator();

        // Valida a categoria e retorna uma notificação contendo quaisquer erros de validação
        Notification notification = validator.validate(category);

        if (notification.hasErros())
            // Lança uma exceção com a mensagem de erro da notificação
            throw new IllegalArgumentException(notification.errorMessage());

        Integer id = category.getIdCategory();
        if (categoryDAO.findOne(id).isEmpty()) {
            // Lança uma exceção se a categoria não for encontrada
            throw new EntityNotFoundException("Product not found");
        }

        // Chama o método create() do objeto categoryDAO para criar a categoria no banco de dados
        return categoryDAO.create(category);
    }
}
