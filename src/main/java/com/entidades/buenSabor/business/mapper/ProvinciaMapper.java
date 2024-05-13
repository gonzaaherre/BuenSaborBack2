package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.PaisService;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaCreateDto;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PaisService.class})
public interface ProvinciaMapper extends BaseMapper<Provincia,ProvinciaDto, ProvinciaCreateDto,ProvinciaCreateDto>{
    @Mapping(target = "pais", source = "idPais",qualifiedByName = "getById")
    Provincia toEntityCreate(ProvinciaCreateDto source);
}
