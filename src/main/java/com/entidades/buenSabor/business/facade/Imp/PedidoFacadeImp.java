package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoFacadeImp extends BaseFacadeImp<Pedido, PedidoDto,PedidoCreateDto ,PedidoCreateDto,Long> implements PedidoFacade {

    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private PedidoService pedidoService;

    public PedidoDto cambiaEstado(Estado estado, Long id) {
        return baseMapper.toDTO(pedidoService.cambiaEstado(estado,id));
    }

    @Override
    public List<PedidoDto> getPedidosEnPreparacion() {
        List<Pedido> pedidosEnCocina = pedidoService.obtenerPedidosEnCocina();
        return pedidosEnCocina.stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> findByEstado(Estado estado) {
        List<Pedido> pedidos =  pedidoService.findByEstado(estado);
        return pedidos.stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Long contarPedidosEnRango(LocalDate initialDate, LocalDate endDate) {
        return pedidoService.contarPedidosEnRango(initialDate,endDate);
    }

//    @Override
//    public void actualizarStockArticulos(Long pedidoId) {
//        pedidoService.actualizarStockArticulos(pedidoId);
//    }
}

