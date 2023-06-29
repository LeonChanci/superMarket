package com.co.supermarket.domain.service;

import com.co.supermarket.domain.Purchase;
import com.co.supermarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClientId(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
