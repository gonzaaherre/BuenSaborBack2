package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.entities.Domicilio;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = LocalidadMapper.class)
public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioDto> {

    DomicilioDto toDTO(Domicilio source);

    Domicilio toEntity(DomicilioDto source);

    List<DomicilioDto> toDTOsList(List<Domicilio> source);
}
