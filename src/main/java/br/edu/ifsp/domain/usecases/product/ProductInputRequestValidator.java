package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class ProductInputRequestValidator extends Validator<Product> {
    @Override
    public Notification validate(Product product) {
        Notification notification = new Notification();
        if (product == null){
            notification.addError("Product is null");
            return notification;
        }

        if(nullOrEmpty(product.getName())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(String.valueOf(product.getPrice()))){
            notification.addError("Name is null or empty");
        }
        return notification;
    }
}
