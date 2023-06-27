package com.co.supermarket.persistence.crud;

import com.co.supermarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /**
     * Obtener una lista de Productos que sean de una categoria especifica
     * @param idCategoria
     * @return
     */
    //QUERY METHOD -> Ordenados por nombre ascendente
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //QUERY NATIVO
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Producto> getProductsByIdCategoria(int idCategoria);

    /**
     * Traer los Productos que se están agotando (cantidades mas bajas) y que estén activos
     * @param cantidaStock
     * @param estado
     * @return
     */
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidaStock, boolean estado);
}
