package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UnidadMedidaService.class})
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDto, ArticuloInsumoCreateDto> {
    @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById")
    ArticuloInsumo toEntityCreate(ArticuloInsumoCreateDto source);
}
