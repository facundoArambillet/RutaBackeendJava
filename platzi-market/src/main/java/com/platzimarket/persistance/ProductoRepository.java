package com.platzimarket.persistance;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.persistance.crud.ProductoCrudRepository;
import com.platzimarket.persistance.entity.Producto;
import com.platzimarket.persistance.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getById(int idProduct) {
        return productoCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategory) {
        List<Producto> productos = productoCrudRepository.findAllByIdCategoria(idCategory);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Boolean save(Product product) {
        Producto producto = mapper.toProducto(product);
        if(mapper.toProduct(productoCrudRepository.save(producto)) != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean delete(int idProduct) {
        Optional<Object> product = productoCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
        if(getById(idProduct).isPresent()) {
            productoCrudRepository.deleteById(idProduct);
            return true;
        }
        else {
            return false;
        }

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
