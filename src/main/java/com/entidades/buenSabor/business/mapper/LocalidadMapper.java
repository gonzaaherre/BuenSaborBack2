package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ProvinciaService;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadCreateDto;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProvinciaService.class})
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadDto, LocalidadCreateDto>{
    @Mapping(target = "provincia", qualifiedByName = "getById")
    Localidad toEntityCreate(LocalidadCreateDto source);
}
