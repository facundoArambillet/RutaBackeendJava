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

    public String save(Product product) {
        productRepository.save(product);
        return "Producto Agregado";
    }

    public String delete(int idProduct) {
        if(getById(idProduct).isPresent()) {
            productRepository.delete(idProduct);
            return "Producto Eliminado";
        }
        else {
            return "El producto a eliminar no se encuentra";
        }
    }
}
