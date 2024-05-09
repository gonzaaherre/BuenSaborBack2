package com.entidades.buenSabor.business.mapper;


import com.entidades.buenSabor.domain.dto.EmpresaDto;

import com.entidades.buenSabor.domain.dto.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDto> {
    EmpresaDto toDTO(Empresa source);

    EmpresaLargeDto toLargeDto(Empresa empresa);

    Empresa toEntity(EmpresaDto source);

    List<EmpresaDto> toDTOsList(List<Empresa> source);
}
