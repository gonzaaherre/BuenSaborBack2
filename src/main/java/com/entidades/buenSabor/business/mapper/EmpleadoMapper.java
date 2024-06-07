package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoEditDto;
import com.entidades.buenSabor.domain.entities.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SucursalService.class, SucursalMapper.class})
public interface EmpleadoMapper extends BaseMapper<Empleado, EmpleadoDto, EmpleadoCreateDto, EmpleadoEditDto> {
    @Mapping(target = "sucursal", source = "idSucursal", qualifiedByName = "getById")
    Empleado toEntityCreate(EmpleadoCreateDto source);

}
