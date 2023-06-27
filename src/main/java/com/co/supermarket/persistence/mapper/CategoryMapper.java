package com.co.supermarket.persistence.mapper;

import com.co.supermarket.domain.Category;
import com.co.supermarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Componente de tipo spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //Convertir una Category a una Categoria
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    //Convertir una Categoria a una Category
    //@InheritInverseConfiguration -> Mappear inversamente entre categorías
    @InheritInverseConfiguration
    //ignore = true -> Se hace para ignorar el objeto productos que si está en la clase Categoria.entity
    @Mapping(target = "productos", ignore = true)
    Categoria toCategory(Category category);
}
