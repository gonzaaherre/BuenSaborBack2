package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoFacadeImp extends BaseFacadeImp<Pedido, PedidoDto,PedidoCreateDto ,PedidoCreateDto,Long> implements PedidoFacade {
    @Autowired
    PedidoService pedidoService;
    @Autowired
    private PedidoMapper pedidoMapper;
    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public List<PedidoDto> getPedidosEnPreparacion() {
        List<Pedido> pedidosEnCocina = pedidoService.obtenerPedidosEnCocina();
        return pedidosEnCocina.stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

//    @Override
//    public void actualizarStockArticulos(Long pedidoId) {
//        pedidoService.actualizarStockArticulos(pedidoId);
//    }
}

