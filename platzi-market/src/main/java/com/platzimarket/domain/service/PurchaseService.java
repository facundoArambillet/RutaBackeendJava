package com.platzimarket.domain.service;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getById(int idCliente) {
        return purchaseRepository.getByClient(idCliente);
    }

    public Boolean save(Purchase purchase) {
        if(purchaseRepository.save(purchase)) {
            return true;
        }
        else {
            return false;
        }

    }

/*    public Boolean delete(int idProduct) {
        if(getById(idProduct).isPresent()) {
            productRepository.delete(idProduct);
            return true;
        }
        else {
            return false;
        }
    }*/
}
