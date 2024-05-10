package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.PaisDto;
import com.entidades.buenSabor.domain.entities.Pais;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaisMapper extends BaseMapper<Pais, PaisDto>{
}
