package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateProductUseCase {
    private  ProductDAO productDAO;

    public CreateProductUseCase(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Integer insert(Product product){
        Validator<Product> validator = new ProductInputRequestValidator();
        Notification notification = validator.validate(product);

        if (notification.hasErros()){
            throw new IllegalArgumentException(notification.errorMessage());
        }

        // O produto não ten um atributo que seja único para cada ítem, como um ProductCode por exemplo,
        // para fazer a verificação se o novo produto a ser inserido no db ja exsite.

        return productDAO.create(product);
    }
}
