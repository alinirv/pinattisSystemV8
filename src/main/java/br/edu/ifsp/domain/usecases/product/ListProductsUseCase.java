package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.List;
import java.util.Optional;

public class ListProductsUseCase {
    private ProductDAO productDAO;

    public ListProductsUseCase(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public Optional<Product> findOne(Integer id){
        if (id == null){
            throw new IllegalArgumentException("ID can not be found");
        }
        return productDAO.findOne(id);
    }

//    public Optional<Product> findByName(String name){
//
//        if (name == null){
//            throw new IllegalArgumentException("Name can not be found");
//        }
//        return productDAO.findByName(name);
//    }

    public Optional<Optional<Product>> findByName(String name) {
        if (Validator.nullOrEmpty(name))
            throw new IllegalArgumentException("Por favor, preencha um produto válido. ");
        return Optional.ofNullable(productDAO.findByName(name));
    }

    public List<Product> findAll(){
        return productDAO.findAll();
    }
}
