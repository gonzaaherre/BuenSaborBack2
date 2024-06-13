package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.LocalidadService;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDtoPedido;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioEditDto;
import com.entidades.buenSabor.domain.entities.Domicilio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {LocalidadService.class})
public interface DomicilioMapper extends BaseMapper<Domicilio, DomicilioDto, DomicilioCreateDto, DomicilioEditDto> {
    @Mapping(target = "localidad", source = "idLocalidad",qualifiedByName = "getById")
    Domicilio toEntityCreate(DomicilioCreateDto source);

    @Named("toEntityCreateSetDomicilio")
    @Mapping(target = "localidad", source = "idLocalidad",qualifiedByName = "getById")
    Set<Domicilio> toEntityCreateSet(Set<DomicilioCreateDto> dtos);

    @Mapping(target = "localidad.nombre", source = "localidad.nombre")
    @Mapping(target = "localidad.id", source = "localidad.id")
    List<DomicilioDtoPedido> toDtoPedido(List<Domicilio> source);
}
