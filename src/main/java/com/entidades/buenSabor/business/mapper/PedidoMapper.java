package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ClienteService;
import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.business.service.FacturaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = { DomicilioService.class, FacturaService.class, FacturaMapper.class, ClienteService.class, DetallePedidoMapper.class})
public interface PedidoMapper extends BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> {

    //source = de donde viene
    //target = a donde va
    @Mappings({
            @Mapping( target = "detallePedidos", qualifiedByName = "toEntityCreateSetArticulo"),
            @Mapping(target = "domicilio", source = "idDomicilio",qualifiedByName = "getById"), // Mapear directamente el objeto Domicilio
            //@Mapping(target = "factura", source = "factura"),
            @Mapping(target = "cliente", source = "idCliente",qualifiedByName = "getById"),
    })
    Pedido toEntityCreate(PedidoCreateDto source);

}
