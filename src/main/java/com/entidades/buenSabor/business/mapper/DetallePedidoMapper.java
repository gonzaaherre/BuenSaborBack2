package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.business.service.DetallePedidoService;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {DetallePedidoService.class, ArticuloService.class})
public interface DetallePedidoMapper extends BaseMapper<DetallePedido, DetallePedidoDto, DetallePedidoCreateDto,DetallePedidoCreateDto>{

    @Mapping(target = "articuloNombre", source = "articulo.denominacion")
    DetallePedidoDto toDTO(DetallePedido source);

    @Mapping(target = "articulo", source = "idArticulo", qualifiedByName = "getById")
    DetallePedido toEntityCreate(DetallePedidoCreateDto source);

    @Named("toEntityCreateSetArticulo")
    @Mapping(target = "articulo", source = "idArticulo",qualifiedByName = "getById")
    Set<DetallePedido>toEntityCreateSet(Set<DetallePedidoCreateDto> dtos);

}
