package com.platzimarket.persistance;

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.repository.PurchaseRepository;
import com.platzimarket.persistance.crud.CompraCrudRepository;
import com.platzimarket.persistance.entity.Compra;
import com.platzimarket.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        return (List<Purchase>) mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(int idClient) {

        return compraCrudRepository.findByIdCliente(idClient).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public boolean save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        if(mapper.toPurchase((Compra) compraCrudRepository.save(compra)) != null) {
            return  true;
        }
        else  {
            return false;
        }

    }
}
