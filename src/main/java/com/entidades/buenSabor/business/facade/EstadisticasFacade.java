package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;

import java.util.Date;
import java.util.List;

public interface EstadisticasFacade {
    List<RankingProductos> bestProducts(Date initialDate, Date endDate);
}
