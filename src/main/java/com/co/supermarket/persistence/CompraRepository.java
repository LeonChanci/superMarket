package com.co.supermarket.persistence;

import com.co.supermarket.domain.Purchase;
import com.co.supermarket.domain.repository.PurchaseRepository;
import com.co.supermarket.persistence.crud.CompraCrudRepository;
import com.co.supermarket.persistence.entity.Compra;
import com.co.supermarket.persistence.mapper.PurchaseMapper;
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

    /**
     * Una lista de Purchases que obtenga todas las compras de la BD
     * @return Lista de todas las Compras
     */
    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    /**
     * Una lista de Purchases de un Client en específica
     * @param clientId Identificación
     * @return Lista de Compras por cliente
     */
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    /**
     * Guardar un Objeto Purchase en BD
     * @param purchase Purchase
     * @return Un Objeto Compra guardado en BD
     */
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getComprasProducto().forEach(comprasProducto -> comprasProducto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
