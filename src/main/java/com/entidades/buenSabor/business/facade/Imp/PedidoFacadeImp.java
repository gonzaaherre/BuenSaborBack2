package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.PedidoDto.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoFacadeImp extends BaseFacadeImp<Pedido, PedidoDto,PedidoCreateDto ,PedidoCreateDto,Long> implements PedidoFacade {

    public PedidoFacadeImp(BaseService<Pedido, Long> baseService, BaseMapper<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}

