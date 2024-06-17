package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PedidoService extends BaseService<Pedido,Long> {
    //Pedido save(PedidoCreateDto pedidoCreateDto);
//     Pedido update(PedidoCreateDto pedidoCreateDto, Long id);
//    void actualizarStockArticulos(Long pedidoId);
    void validarStock(Set<DetallePedido> detalles);

    boolean aplicarDescuento(Pedido pedido);


    void calcularTiempoEstimado(Pedido pedido);

    List<Pedido> obtenerPedidosEnCocina();

    int contarCocineros();

    Pedido cambiaEstado(Estado estado, Long id);

    List<Pedido> findByEstado(Estado estado);

    Optional<Pedido> findById(Long id);

    Long contarPedidosEnRango(LocalDate initialDate, LocalDate endDate);
}
