package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDto> {
}
