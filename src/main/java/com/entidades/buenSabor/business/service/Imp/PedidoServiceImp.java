package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImp extends BaseServiceImp<Pedido,Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public Pedido save(PedidoCreateDto pedidoCreateDto) {
        if (pedidoCreateDto.getDetallePedidos() == null || pedidoCreateDto.getDetallePedidos().isEmpty()) {
            throw new IllegalArgumentException("Un pedido debe tener al menos un detalle de pedido.");
        }
        Pedido pedido = pedidoMapper.toEntityCreate(pedidoCreateDto);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(PedidoCreateDto pedidoCreateDto, Long id) {
        if (pedidoCreateDto.getDetallePedidos() == null || pedidoCreateDto.getDetallePedidos().isEmpty()) {
            throw new IllegalArgumentException("Un pedido debe tener al menos un detalle de pedido.");
        }
        var pedidoDB = pedidoRepository.findById(id);
        if (pedidoDB.isEmpty()) {
            throw new RuntimeException("No se encontró una entidad con el id " + id);
        }
        Pedido pedido = pedidoMapper.toEntityCreate(pedidoCreateDto);
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }
}