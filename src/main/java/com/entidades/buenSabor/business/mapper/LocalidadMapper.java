package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalidadMapper extends BaseMapper<Localidad, LocalidadDto>{
}
