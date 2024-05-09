package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.LocalidadDto;

import java.util.List;

public interface LocalidadFacade extends BaseFacade<LocalidadDto, Long> {

    List<LocalidadDto> findByProvinciaId(Long id);
}
