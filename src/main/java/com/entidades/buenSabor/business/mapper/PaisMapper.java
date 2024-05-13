package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.Pais.PaisCreateDto;
import com.entidades.buenSabor.domain.dto.Pais.PaisDto;
import com.entidades.buenSabor.domain.entities.Pais;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends BaseMapper<Pais, PaisDto, PaisCreateDto,PaisCreateDto>{
}
