package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.EstadisticasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasFacade estadisticasFacade;

    @GetMapping("/rankin")
    public ResponseEntity<?> rankin (
            @RequestParam("fechaDesde") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam("fechaHasta") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta){
        return ResponseEntity.ok(estadisticasFacade.bestProducts(fechaDesde, fechaHasta));
    }
}
