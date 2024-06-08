package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.EstadisticasFacade;
import com.entidades.buenSabor.business.service.EstadisticasService;
import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadisticasFacadeImp implements EstadisticasFacade {

    @Autowired
    private EstadisticasService estadisticasService;

    @Override
    public List<RankingProductos> bestProducts(Date initialDate, Date endDate) {
        return estadisticasService.bestProducts(initialDate, endDate);
    }
}
