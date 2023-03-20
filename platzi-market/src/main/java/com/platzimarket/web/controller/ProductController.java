package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> getById(@PathVariable("idProduct") int idProduct) {
        return productService.getById(idProduct)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("idCategory") int idCategory) {
        return productService.getByCategory(idCategory)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Boolean> save(@RequestBody Product product) {
        if(productService.save(product)) {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Boolean> delete(@PathVariable int idProduct) {
        if(productService.delete(idProduct)) {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

    }
}
