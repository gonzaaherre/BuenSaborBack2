package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;

import java.util.List;
import java.util.Set;

public interface PedidoService extends BaseService<Pedido,Long> {
    //Pedido save(PedidoCreateDto pedidoCreateDto);
//     Pedido update(PedidoCreateDto pedidoCreateDto, Long id);
//    void actualizarStockArticulos(Long pedidoId);
    void validarStock(Set<DetallePedido> detalles);

    void aplicarDescuento(Pedido pedido);

    void calcularTiempoEstimado(Pedido pedido);

    List<Pedido> obtenerPedidosEnCocina();

    int contarCocineros();

    Pedido cambiaEstado(Estado estado, Long id);

    List<Pedido> findByEstado(Estado estado);
}
