package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaCreateDto;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaDto;

import java.util.List;

public interface ProvinciaFacade extends BaseFacade<ProvinciaDto, ProvinciaCreateDto, ProvinciaCreateDto, Long> {
    List<ProvinciaDto> findByPaisId(Long id);
}
