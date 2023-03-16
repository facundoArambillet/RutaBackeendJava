package com.platzimarket.persistance.crud;

import com.platzimarket.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    List<Producto> findAllByIdCategoria(int idCategoria);
}
