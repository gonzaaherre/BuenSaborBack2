package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadCreateDto;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadDto;

import java.util.List;

public interface LocalidadFacade extends BaseFacade<LocalidadDto, LocalidadCreateDto, LocalidadCreateDto, Long> {

    List<LocalidadDto> findByProvinciaId(Long id);
}
