package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.PedidosCliente;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.RankingProductos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EstadisticasFacade {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
    List<Object[]> ingresosDiarios(Date initialDate, Date endDate);
    List<Object[]> ingresosMensuales(Date initialDate, Date endDate);
    CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);
    List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate);
}
