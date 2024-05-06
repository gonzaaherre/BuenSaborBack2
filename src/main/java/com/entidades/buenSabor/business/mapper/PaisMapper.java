package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.dto.PaisDto;
import com.entidades.buenSabor.domain.entity.Localidad;
import com.entidades.buenSabor.domain.entity.Pais;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaisMapper extends BaseMapper<Pais, PaisDto>{
    PaisDto toDTO(Pais source);
    List<PaisDto> toDTOsList(List<Pais> source);
}
