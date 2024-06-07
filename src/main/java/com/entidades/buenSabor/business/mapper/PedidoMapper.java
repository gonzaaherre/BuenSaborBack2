package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.DetallePedidoService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {SucursalService.class, DetallePedidoService.class, DetallePedidoMapper.class})
public interface PedidoMapper extends BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> {

    @Mappings({
            @Mapping( target = "detallePedidos", qualifiedByName = "toEntityCreateSetArticulo")
           // @Mapping( source = "idSucursal", target = "sucursal", qualifiedByName = "getById")
    })
    Pedido toEntityCreate(PedidoCreateDto source);
}
