package com.platzimarket.domain.repository;

import com.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getById(int idProduct);
    Optional<List<Product>> getByCategory(int idCategory);
    Boolean save(Product product);
    Boolean delete(int idProduct);
}
