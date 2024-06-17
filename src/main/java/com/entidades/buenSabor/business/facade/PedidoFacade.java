package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.enums.Estado;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PedidoFacade extends BaseFacade<PedidoDto, PedidoCreateDto,PedidoCreateDto, Long> {

    public PedidoDto cambiaEstado(Estado estado, Long id);
    //void actualizarStockArticulos(Long pedidoId);
    List<PedidoDto> getPedidosEnPreparacion();
    public List<PedidoDto> findByEstado(Estado estado);
    public Long contarPedidosEnRango(LocalDate initialDate, LocalDate endDate);
}
