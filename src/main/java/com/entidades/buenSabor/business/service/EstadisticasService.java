package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;

import java.util.Date;
import java.util.List;

public interface EstadisticasService {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
}
