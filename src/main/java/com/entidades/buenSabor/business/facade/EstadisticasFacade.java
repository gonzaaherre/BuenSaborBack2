package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.Estadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EstadisticasFacade {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
    List<Object[]> ingresosDiarios(Date initialDate, Date endDate);
    List<Object[]> ingresosMensuales(Date initialDate, Date endDate);
    CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);
}
