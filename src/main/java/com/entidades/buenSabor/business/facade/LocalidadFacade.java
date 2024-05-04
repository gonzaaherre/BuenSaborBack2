package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.entity.Localidad;

import java.util.List;

public interface LocalidadFacade extends BaseFacade<LocalidadDto, Long> {

    List<LocalidadDto> findByProvinciaId(Long id);
}
