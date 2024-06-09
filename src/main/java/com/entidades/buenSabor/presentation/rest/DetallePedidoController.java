package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.DetallePedidoFacadeImpl;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoDto;
import com.entidades.buenSabor.domain.entities.DetallePedido;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/detallesPedido")
public class DetallePedidoController extends BaseControllerImp<DetallePedido, DetallePedidoDto, DetallePedidoCreateDto,DetallePedidoCreateDto,Long, DetallePedidoFacadeImpl> {
    public DetallePedidoController(DetallePedidoFacadeImpl facade) {
        super(facade);
    }
}
