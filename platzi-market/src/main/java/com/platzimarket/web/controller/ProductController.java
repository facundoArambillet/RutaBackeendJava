package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{idProduct}")
    public Optional<Product> getById(@PathVariable("idProduct") int idProduct) {
        return productService.getById(idProduct);
    }

    @GetMapping("/category/{idCategory}")
    public Optional<List<Product>> getByCategory(@PathVariable("idCategory") int idCategory) {
        return productService.getByCategory(idCategory);
    }

    @PostMapping()
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "Producto Agregado";
    }

    @DeleteMapping("/delete/{idProduct}")
    public String delete(@PathVariable int idProduct) {
        if(getById(idProduct).isPresent()) {
            productService.delete(idProduct);
            return "Producto Eliminado";
        }
        else {
            return "El producto a eliminar no se encuentra";
        }
    }
}
