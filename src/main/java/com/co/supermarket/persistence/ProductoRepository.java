package com.co.supermarket.persistence;

import com.co.supermarket.persistence.crud.ProductoCrudRepository;
import com.co.supermarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Con @Repository indicamos a Spring que esta clase interactúa con la BD
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    /**
     * Una lista de Productos que obtenga todos los productos de la BD
     * @return Lista de todos los Productos
     */
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    /**
     * Una lista de Productos de una Categoría específica
     * @param idCategoria
     * @return Lista de Productos por categoría
     */
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    /**
     * Una Lista Optional de Productos escasos
     * @param cantidad
     * @return Un Optional con una Lista de Productos escasos -> Programación Funcional
     */
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    /**
     * Obtener un Producto por medio de su ID
     * @param idProducto
     * @return Optional del Producto -> Programación Funcional
     */
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    /**
     * Guardar un Objeto Producto en BD
     * @param producto
     * @return Un Objeto Producto guardado en BD
     */
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    /**
     * Eliminar un Objeto Producto por su ID
     * @param idProducto
     */
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
