package com.platzimarket.web.controller;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPurchase}")
    public ResponseEntity<List<Purchase>> getById(@PathVariable("idPurchase") int idPurchase) {
        return purchaseService.getById(idPurchase)
                .map(purchase -> new ResponseEntity<>(purchase,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping()
    public ResponseEntity<Boolean> save(@RequestBody Purchase purchase) {
        if(purchaseService.save(purchase)) {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

    }

/*    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Boolean> delete(@PathVariable int idProduct) {
        if(productService.delete(idProduct)) {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

    }*/
}
