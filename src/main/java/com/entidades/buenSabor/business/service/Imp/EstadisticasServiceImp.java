package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.EstadisticasService;
import com.entidades.buenSabor.domain.dto.Estadisticas.RankingProductos;
import com.entidades.buenSabor.repositories.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadisticasServiceImp implements EstadisticasService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<RankingProductos> bestProducts(Date initialDate, Date endDate) {
        return detallePedidoRepository.bestProducts(initialDate, endDate);
    }
}
