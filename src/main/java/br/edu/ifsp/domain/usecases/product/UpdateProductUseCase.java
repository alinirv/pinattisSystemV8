package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateProductUseCase {

    private  ProductDAO productDAO;

    public UpdateProductUseCase(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Boolean update(Product product){
        Validator<Product> validator = new ProductInputRequestValidator();
        Notification notification = validator.validate(product);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        Integer id = product.getId();
        if (productDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }

        return productDAO.update(product);
    }
}
