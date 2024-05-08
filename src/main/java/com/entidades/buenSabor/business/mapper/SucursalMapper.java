package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entity.Domicilio;
import com.entidades.buenSabor.domain.entity.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = DomicilioMapper.class)
public interface SucursalMapper extends BaseMapper<Sucursal, SucursalDto>{

    SucursalDto toDTO(Sucursal source);

    Sucursal toEntity(SucursalDto source);

}
