package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto>{
}
