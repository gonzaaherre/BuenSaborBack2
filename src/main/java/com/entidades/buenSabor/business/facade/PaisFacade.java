package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Pais.PaisCreateDto;
import com.entidades.buenSabor.domain.dto.Pais.PaisDto;

public interface PaisFacade extends BaseFacade<PaisDto, PaisCreateDto, PaisCreateDto,Long> {
}
