package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;

public interface PedidoFacade extends BaseFacade<PedidoDto, PedidoCreateDto,PedidoCreateDto, Long> {
}
