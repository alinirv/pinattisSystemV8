package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;

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

    public List<Product> findAll(){
        return productDAO.findAll();
    }
}
