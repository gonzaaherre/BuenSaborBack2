package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ClienteFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteFacadeImpl extends BaseFacadeImp<Cliente, ClienteDto, ClienteCreateDto,ClienteCreateDto,Long> implements ClienteFacade {
    public ClienteFacadeImpl(BaseService<Cliente, Long> baseService, BaseMapper<Cliente, ClienteDto, ClienteCreateDto, ClienteCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
