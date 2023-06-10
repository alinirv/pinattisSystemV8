package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class DisableProductUseCase {
    private ProductDAO productDAO;

    public DisableProductUseCase(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public boolean disableProduct(Integer id){
        if (id == null || productDAO.findOne(id).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        return productDAO.deleteByKey(id);
    }

    public boolean disableProduct(Product product){
        if (product == null || productDAO.findOne(product.getId()).isEmpty()){
            throw new EntityNotFoundException("Product not found");
        }
        return productDAO.delete(product);
    }
}
