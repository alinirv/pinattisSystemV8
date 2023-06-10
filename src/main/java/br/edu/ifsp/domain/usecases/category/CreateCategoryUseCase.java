package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateCategoryUseCase {
    private CategoryDAO categoryDAO;

    public CreateCategoryUseCase(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Integer insert(Category category) {
        // Cria uma instância do validador para a entrada da categoria
        Validator<Category> validator = new CategoryInputRequestValidator();

        // Valida a categoria e retorna uma notificação contendo quaisquer erros de validação
        Notification notification = validator.validate(category);

        if (notification.hasErros())
            // Exceção - lança uma exceção com a mensagem de erro da notificação
            throw new IllegalArgumentException(notification.errorMessage());

        // Chama o método create() do objeto categoryDAO para criar a categoria no banco de dados
        return categoryDAO.create(category);
    }
}
