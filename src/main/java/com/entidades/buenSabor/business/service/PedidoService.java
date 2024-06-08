package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.entities.Pedido;

public interface PedidoService extends BaseService<Pedido,Long> {
    Pedido save(PedidoCreateDto pedidoCreateDto);
    Pedido update(PedidoCreateDto pedidoCreateDto, Long id);
}
