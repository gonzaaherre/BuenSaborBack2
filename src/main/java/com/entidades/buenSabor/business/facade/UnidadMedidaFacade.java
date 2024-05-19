package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadDeMedidaEditDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaDto;

public interface UnidadMedidaFacade extends BaseFacade<UnidadMedidaDto, UnidadMedidaCreateDto, UnidadDeMedidaEditDto,Long> {
}
