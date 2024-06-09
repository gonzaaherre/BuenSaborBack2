package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.ClienteService;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl extends BaseServiceImp<Cliente,Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}
