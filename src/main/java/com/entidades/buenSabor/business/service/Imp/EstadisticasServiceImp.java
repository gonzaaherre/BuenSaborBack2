package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.EstadisticasService;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.PedidosCliente;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.RankingProductos;
import com.entidades.buenSabor.repositories.DetallePedidoRepository;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EstadisticasServiceImp implements EstadisticasService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<RankingProductos> bestProducts(Date initialDate, Date endDate) {
        return detallePedidoRepository.bestProducts(initialDate, endDate);
    }

    @Override
    public List<Object[]> ingresosDiarios(Date initialDate, Date endDate) {
        return pedidoRepository.ingresosDiarios(initialDate, endDate);
    }

    @Override
    public List<Object[]> ingresosMensuales(Date initialDate, Date endDate) {
        return pedidoRepository.ingresosMensuales(initialDate, endDate);
    }

    @Override
    public CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate) {
        return pedidoRepository.findCostosGananciasByFecha(initialDate, endDate);
    }

    @Override
    public List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate) {
        return pedidoRepository.findCantidadPedidosPorCliente(startDate,endDate);
    }
}
