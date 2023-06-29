package com.co.supermarket.domain.repository;

import com.co.supermarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    /**
     * Obtener una lista de Purchases
     */
    List<Purchase> getAll();

    /**
     * Obtener una lista de Purchases que sean de un Client especifico
     */
    Optional<List<Purchase>> getByClient(String clientId);

    /**
     * Guardar un Objeto Purchase en BD
     */
    Purchase save(Purchase purchase);
}
