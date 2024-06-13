package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.ClienteService;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.domain.entities.Domicilio;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.repositories.ClienteRepository;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl extends BaseServiceImp<Cliente,Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public List<Pedido> getAllPedido(Long id) {
        return pedidoRepository.findByClienteId(id);
    }

    @Override
    public List<Domicilio> getAllDomicilios(Long id) {
        return clienteRepository.findAllDomiciliosByClienteId(id);
    }

    public Cliente addDomicilio(Domicilio d, Long id){
        Cliente cliente = getById(id);
        cliente.getDomicilios().add(d);
        return clienteRepository.save(cliente);
    }


}
