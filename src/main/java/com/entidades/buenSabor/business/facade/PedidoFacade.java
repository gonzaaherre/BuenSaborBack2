package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoDto;

public interface PedidoFacade extends BaseFacade<PedidoDto, PedidoCreateDto,PedidoCreateDto, Long> {
}
