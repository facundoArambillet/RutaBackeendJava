package com.platzimarket.persistance.crud;

import com.platzimarket.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

}
