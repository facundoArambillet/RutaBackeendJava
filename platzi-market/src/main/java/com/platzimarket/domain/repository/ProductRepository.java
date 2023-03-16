package com.platzimarket.domain.repository;

import com.platzimarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getById(int idProduct);
    Optional<List<Product>> getByCategory(int idCategory);
    String save(Product product);
    String delete(int idProduct);
}
