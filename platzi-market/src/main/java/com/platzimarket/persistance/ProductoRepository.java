package com.platzimarket.persistance;

import com.platzimarket.persistance.crud.ProductoCrudRepository;
import com.platzimarket.persistance.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Optional<Producto> getById(Integer idProducto) {
        return  productoCrudRepository.findById(idProducto);
    }

    public List<Producto> getByCategoria(Integer idCategoria) {
        return productoCrudRepository.findAllByIdCategoria(idCategoria);
    }


    public String createProduct (Producto nuevoProducto) {
        productoCrudRepository.save(nuevoProducto);
        return "Producto creado";
    }

//    public String updateProduct (Producto nuevoProducto, Integer id) {
////        Optional<Producto> producto = productoCrudRepository.findById(id);
////        if (producto != null) {
////            producto = Optional.ofNullable(nuevoProducto);
////            productoCrudRepository.save(producto);
////        }
//        return "Producto creado";
//
//    }
    public String deleteProduct (int idProducto) {
        productoCrudRepository.deleteById(idProducto);
        return "Producto Eliminado";
    }
}
