package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoDto;

public interface DetallePedidoFacade extends BaseFacade<DetallePedidoDto, DetallePedidoCreateDto,DetallePedidoCreateDto, Long> {
}
