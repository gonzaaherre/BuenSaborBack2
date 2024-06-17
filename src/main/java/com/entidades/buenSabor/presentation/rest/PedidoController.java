package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PedidoFacadeImp;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
    @RequestMapping("/pedido")
public class PedidoController extends BaseControllerImp<Pedido, PedidoDto, PedidoCreateDto,PedidoCreateDto,Long, PedidoFacadeImp> {
    public PedidoController(PedidoFacadeImp facade) {
        super(facade);
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody PedidoCreateDto pedidoCreateDto){
        try {
            return super.create(pedidoCreateDto);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/cambiaEstado/{id}")
    public ResponseEntity<PedidoDto> cambiaEstado(@RequestBody Estado estado,@PathVariable Long id ) {
        return ResponseEntity.ok(facade.cambiaEstado(estado, id));
    }

    @GetMapping("/en-preparacion")
    public ResponseEntity<List<PedidoDto>> getPedidosEnPreparacion() {
        List<PedidoDto> pedidosEnPreparacion = facade.getPedidosEnPreparacion();
        return ResponseEntity.ok(pedidosEnPreparacion);
    }

    @GetMapping("/findByEstado")
    public ResponseEntity<List<PedidoDto>> findByEstado(@RequestParam Estado estado) {
        return ResponseEntity.ok(facade.findByEstado(estado));
    }

    @GetMapping("/countPorFecha")
    public ResponseEntity<Long> contadorPorFecha(
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta) {
        return ResponseEntity.ok(facade.contarPedidosEnRango(fechaDesde, fechaHasta));
    }
}