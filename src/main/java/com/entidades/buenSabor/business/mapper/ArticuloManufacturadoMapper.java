package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloManufacturadoDetalleService;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ArticuloManufacturadoDetalleService.class, UnidadMedidaService.class})
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto> {

    @Mappings({
        @Mapping(source = "idsArticuloManufacturadoDetalles", target = "articuloManufacturadoDetalles", qualifiedByName = "getById"),
        @Mapping(target = "unidadMedida", qualifiedByName = "getById")
    })
    public ArticuloManufacturado toEntityCreate(ArticuloManufacturadoCreateDto source);
}