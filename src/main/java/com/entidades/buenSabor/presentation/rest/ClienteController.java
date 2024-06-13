package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ClienteFacadeImpl;
import com.entidades.buenSabor.business.service.ClienteService;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController extends BaseControllerImp<Cliente, ClienteDto, ClienteCreateDto,ClienteCreateDto,Long, ClienteFacadeImpl> {
    public ClienteController(ClienteFacadeImpl facade) {
        super(facade);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getClienteByEmail(@PathVariable String email) {
        return ResponseEntity.ok(facade.findByEmail(email));
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<?> getAllPedidos(@PathVariable Long id) {
        return ResponseEntity.ok(facade.getAllPedidos(id));
    }

    @GetMapping("/domicilios/{id}")
    public ResponseEntity<?> getAllDomicilios(@PathVariable Long id) {
        return ResponseEntity.ok(facade.getAllDomicilios(id));
    }

    @PutMapping("/addDomicilios/{id}")
    public ResponseEntity<?> addDomicilio(@PathVariable Long id, @RequestBody DomicilioCreateDto d) {
        return ResponseEntity.ok(facade.addDomicilio(d, id));
    }
}
