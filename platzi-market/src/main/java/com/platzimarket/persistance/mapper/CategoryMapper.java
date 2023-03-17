package com.platzimarket.persistance.mapper;

import com.platzimarket.domain.Category;
import com.platzimarket.persistance.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "idCategory"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);


    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
