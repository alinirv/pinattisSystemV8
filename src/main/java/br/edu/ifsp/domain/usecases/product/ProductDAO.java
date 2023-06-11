package br.edu.ifsp.domain.usecases.product;

import br.edu.ifsp.domain.entities.product.Product;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface ProductDAO extends DAO<Product, Integer> {
    Optional<Product> findByName(String name);
}
