package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.DetallePedidoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoFacadeImpl extends BaseFacadeImp<DetallePedido,DetallePedidoDto, DetallePedidoCreateDto,DetallePedidoCreateDto,Long> implements DetallePedidoFacade {


    public DetallePedidoFacadeImpl(BaseService<DetallePedido, Long> baseService, BaseMapper<DetallePedido, DetallePedidoDto, DetallePedidoCreateDto, DetallePedidoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
