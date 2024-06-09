package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;

public interface PedidoService extends BaseService<Pedido,Long> {

    Pedido cambiaEstado(Estado estado, Long id);
}
