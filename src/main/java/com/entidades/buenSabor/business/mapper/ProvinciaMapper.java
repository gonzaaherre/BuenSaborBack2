package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.ProvinciaDto;
import com.entidades.buenSabor.domain.entity.Provincia;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProvinciaMapper extends BaseMapper<Provincia,ProvinciaDto>{
    ProvinciaDto toDTO(Provincia source);
    Provincia toEntity(ProvinciaDto source);
    List<ProvinciaDto> toDTOsList(List<Provincia> source);
    List<Provincia> toEntitiesList(List<ProvinciaDto> source);


}
