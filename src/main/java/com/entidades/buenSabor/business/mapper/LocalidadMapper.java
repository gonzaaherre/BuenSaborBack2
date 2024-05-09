package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadDto>{

    LocalidadDto toDTO(Localidad source);
    public Localidad toEntity(LocalidadDto source);
    List<LocalidadDto> toDTOsList(List<Localidad> source);
}
