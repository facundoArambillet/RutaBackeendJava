package com.platzimarket.domain.service;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(int idProduct) {
            return productRepository.getById(idProduct);
    }

    public Optional<List<Product>> getByCategory(int idCategory) {
        return productRepository.getByCategory(idCategory);
    }

    public Boolean save(Product product) {
        if(productRepository.save(product)) {
            return true;
        }
        else {
            return false;
        }

    }

    public Boolean delete(int idProduct) {
        if(getById(idProduct).isPresent()) {
            productRepository.delete(idProduct);
            return true;
        }
        else {
            return false;
        }
    }
}
