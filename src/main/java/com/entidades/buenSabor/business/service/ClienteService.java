package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.domain.entities.Domicilio;
import com.entidades.buenSabor.domain.entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface ClienteService extends BaseService<Cliente,Long> {
    Cliente findByEmail(String email);

    List<Pedido> getAllPedido(Long id);

    List<Domicilio>  getAllDomicilios(Long id);

    Cliente addDomicilio(Domicilio d, Long id);
}
