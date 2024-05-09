package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DomicilioMapper.class )
public interface SucursalMapper extends BaseMapper<Sucursal, SucursalDto>{

    SucursalDto toDTO(Sucursal source);

    Sucursal toEntity(SucursalDto source);

}
