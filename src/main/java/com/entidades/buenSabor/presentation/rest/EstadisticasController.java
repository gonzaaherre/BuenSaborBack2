package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.EstadisticasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasFacade estadisticasFacade;

    @GetMapping("/ranking")
    public ResponseEntity<?> rankin (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.bestProducts(fechaDesde, fechaHasta));
    }

    @GetMapping("/recaudacionesDiarias")
    public ResponseEntity<?> recaudacionesDiarias (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.ingresosDiarios(fechaDesde, fechaHasta));
    }

    @GetMapping("/recaudacionesMensuales")
    public ResponseEntity<?> recaudacionesMensuales (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.ingresosMensuales(fechaDesde, fechaHasta));
    }

    @GetMapping("/costosGanancias")
    public ResponseEntity<?> costosGanancias (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.findCostosGananciasByFecha(fechaDesde, fechaHasta));
    }

    @GetMapping("/pedidosCliente")
    public ResponseEntity<?> pedidosCliente (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.findCantidadPedidosPorCliente(fechaDesde, fechaHasta));
    }
}
