package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PedidoFacadeImp;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class PedidoController extends BaseControllerImp<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto,Long, PedidoFacadeImp> {
    public PedidoController(PedidoFacadeImp facade) {
        super(facade);
    }
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerImp.class);

    @GetMapping("/en-preparacion")
    public ResponseEntity<List<PedidoDto>> getPedidosEnPreparacion() {
        logger.info("INICIO GET PEDIDOS EN PREPARACION");
        List<PedidoDto> pedidosEnPreparacion = facade.getPedidosEnPreparacion();
        return ResponseEntity.ok(pedidosEnPreparacion);
    }
}