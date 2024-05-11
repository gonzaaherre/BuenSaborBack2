package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.EmpresaService;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DomicilioMapper.class, EmpresaService.class} )
public interface SucursalMapper extends BaseMapper<Sucursal, SucursalDto, SucursalCreateDto>{
    @Mapping(target = "empresa", source = "idEmpresa", qualifiedByName = "getById")
    public Sucursal toEntityCreate(SucursalCreateDto source);
}
