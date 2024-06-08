package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.EstadisticasFacade;
import com.entidades.buenSabor.business.service.EstadisticasService;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.PedidosCliente;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.RankingProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public List<Object[]> ingresosDiarios(Date initialDate, Date endDate) {
        return estadisticasService.ingresosDiarios(initialDate, endDate);
    }

    @Override
    public List<Object[]> ingresosMensuales(Date initialDate, Date endDate) {
        return estadisticasService.ingresosMensuales(initialDate, endDate);
    }

    @Override
    public CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate) {
        return estadisticasService.findCostosGananciasByFecha(initialDate, endDate);
    }

    @Override
    public List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate) {
        return estadisticasService.findCantidadPedidosPorCliente(startDate, endDate);
    }
}
