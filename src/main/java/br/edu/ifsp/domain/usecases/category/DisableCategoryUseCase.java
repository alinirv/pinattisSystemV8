package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class DisableCategoryUseCase {

    private CategoryDAO categoryDAO;

    public DisableCategoryUseCase(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    // Método para desativar uma categoria pelo ID
    public boolean disableRoom(Integer id){
        // Verifica se o ID é nulo ou se a categoria não existe no banco de dados
        if (id == null || categoryDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Category not found");
        }
        return categoryDAO.deleteByKey(id);
    }

    // Método para desativar uma categoria pelo objeto Category
    public boolean disableRoom(Category category){
        // Verifica se a categoria é nula ou se a categoria não existe no banco de dados
        if (category == null || categoryDAO.findOne(category.getIdCategory()).isEmpty()){
            throw new EntityNotFoundException("Category not found");
        }
        return categoryDAO.delete(category);
    }
}
