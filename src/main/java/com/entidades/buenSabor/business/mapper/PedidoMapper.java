package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.business.service.FacturaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {SucursalService.class, DomicilioService.class, FacturaService.class})
public interface PedidoMapper extends BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> {

    //source = de donde viene
    //target = a donde va
    @Mappings({
            @Mapping(target = "sucursal", source = "idSucursal", qualifiedByName = "getById"),
            @Mapping(target = "domicilio", source = "IDdomicilio",qualifiedByName = "getById"), // Mapear directamente el objeto Domicilio
            @Mapping(target = "factura",source ="idfactura",qualifiedByName = "getById" )
    })
    Pedido toEntityCreate(PedidoCreateDto source);

}
