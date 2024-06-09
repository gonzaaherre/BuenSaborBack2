package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EstadisticasFacade {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
    List<IngresosDiarios> ingresosDiarios(Date initialDate, Date endDate);
    List<IngresosMensuales> ingresosMensuales(Date initialDate, Date endDate);
    CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);
    List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate);
    byte[] generarReporteExcel(Date fechaDesde, Date fechaHasta) throws IOException;
}
