package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entity.Empresa;
import com.entidades.buenSabor.domain.entity.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SucursalMapper.class)
public interface EmpresaMapper {
    EmpresaDto toDTO(Empresa source);

    Empresa toEntity(EmpresaDto source);
}
