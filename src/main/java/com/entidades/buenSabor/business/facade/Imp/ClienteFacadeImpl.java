package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ClienteFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.ClienteService;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFacadeImpl extends BaseFacadeImp<Cliente, ClienteDto, ClienteCreateDto,ClienteCreateDto,Long> implements ClienteFacade {
    public ClienteFacadeImpl(BaseService<Cliente, Long> baseService, BaseMapper<Cliente, ClienteDto, ClienteCreateDto, ClienteCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public ClienteDto findByEmail(String email) {
        return baseMapper.toDTO(clienteService.findByEmail(email));
    }

    public List<PedidoDto> getAllPedidos(Long id) {
        return pedidoMapper.toDTOsList(clienteService.getAllPedido(id));
    }
}
