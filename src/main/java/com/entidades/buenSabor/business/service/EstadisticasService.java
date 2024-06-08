package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.dto.Estadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EstadisticasService {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
    List<Object[]> ingresosDiarios(Date initialDate, Date endDate);
    List<Object[]> ingresosMensuales(Date initialDate, Date endDate);
    CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);
}
