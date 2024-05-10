package com.entidades.buenSabor.business.mapper;


import com.entidades.buenSabor.domain.dto.EmpresaDto;

import com.entidades.buenSabor.domain.dto.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends BaseMapper<Empresa, EmpresaDto> {
    EmpresaLargeDto toLargeDto(Empresa empresa);
}
