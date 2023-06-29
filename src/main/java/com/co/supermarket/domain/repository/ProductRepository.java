package com.co.supermarket.domain.repository;

import com.co.supermarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    /**
     * Obtener una lista de Products
     */
    List<Product> getAll();

    /**
     * Una lista de Productos de una Categoría específica
     */
    Optional<List<Product>> getByCategoty(int categoryId);

    /**
     * Una Lista Optional de Products escasos
     */
    Optional<List<Product>> getScarseProducts(int quantity);

    /**
     * Obtener Product por Id
     */
    Optional<Product> getProduct(int productId);

    /**
     * Guardar un Objeto Product en BD
     */
    Product save(Product product);

    /**
     * Eliminar un Objeto Product por Id
     */
    void delete(int productId);

}
