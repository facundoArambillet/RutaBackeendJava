package com.platzimarket.persistance.mapper;


import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.PurchaseItem;
import com.platzimarket.persistance.entity.Compra;
import com.platzimarket.persistance.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "idProduct"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "compra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
