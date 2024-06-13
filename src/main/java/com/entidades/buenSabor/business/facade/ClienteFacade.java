package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDtoPedido;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.domain.entities.Domicilio;

import java.util.List;

public interface ClienteFacade extends BaseFacade<ClienteDto, ClienteCreateDto,ClienteCreateDto,Long> {
    ClienteDto findByEmail(String email);
    public Object getAllPedidos(Long id);
    public List<DomicilioDtoPedido> getAllDomicilios(Long id);
    ClienteDto addDomicilio(DomicilioCreateDto d, Long id);
}
