package com.co.supermarket.persistence.mapper;

import com.co.supermarket.domain.Product;
import com.co.supermarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//uses =  {CategoryMapper.class} -> para cuando se mapea la categoría use el CategoryMapper existente
@Mapper(componentModel = "spring", uses =  {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    //Ignorar el camp codigoBarras que si está en Producto.entity
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
