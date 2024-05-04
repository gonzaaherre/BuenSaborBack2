package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.entity.Localidad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadDto>{

    LocalidadDto toDTO(Localidad source);
    Localidad toEntity(LocalidadDto source);
    List<LocalidadDto> toDTOsList(List<Localidad> source);
    List<Localidad> toEntitiesList(List<LocalidadDto> source);
}
