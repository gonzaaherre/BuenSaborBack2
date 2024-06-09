package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;

public interface ClienteFacade extends BaseFacade<ClienteDto, ClienteCreateDto,ClienteCreateDto,Long> {
}
