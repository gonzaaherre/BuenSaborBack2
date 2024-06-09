package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteService extends BaseService<Cliente,Long> {
    Cliente findByEmail(String email);
}
