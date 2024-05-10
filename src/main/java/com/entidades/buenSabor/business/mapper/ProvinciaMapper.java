package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ProvinciaDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper extends BaseMapper<Provincia,ProvinciaDto>{
}
