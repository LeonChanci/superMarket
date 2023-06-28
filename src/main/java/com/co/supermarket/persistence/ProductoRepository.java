package com.co.supermarket.persistence;

import com.co.supermarket.domain.Product;
import com.co.supermarket.domain.repository.ProductRepository;
import com.co.supermarket.persistence.crud.ProductoCrudRepository;
import com.co.supermarket.persistence.entity.Producto;
import com.co.supermarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Con @Repository indicamos a Spring que esta clase interactúa con la BD
@Repository
public class ProductoRepository implements ProductRepository {
    //Inyección de Dependencias
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    /**
     * Una lista de Productos que obtenga todos los productos de la BD
     * @return Lista de todos los Productos
     */
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }


    /**
     * Una lista de Productos de una Categoría específica
     * @param categoryId
     * @return Lista de Productos por categoría
     */
    @Override
    public Optional<List<Product>> getByCategoty(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }


    /**
     * Una Lista Optional de Productos escasos
     * @param quantity
     * @return Un Optional con una Lista de Productos escasos -> Programación Funcional
     */
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //Función lambda para mapear los productos y retornar la  Lista de Optional
        return productos.map(p -> mapper.toProducts(p));
    }

    /**
     * Obtener un Producto por Id
     * @param productId
     * @return Optional del Producto -> Programación Funcional
     */
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(p-> mapper.toProduct(p));
    }

    /**
     * Guardar un Objeto Producto en BD
     * @param product Product
     * @return Un Objeto Producto guardado en BD
     */
    @Override
    public Product save(Product product) {
        //Conversión al contrario
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     * Eliminar un Objeto Producto por Id
     * @param productId
     */
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
