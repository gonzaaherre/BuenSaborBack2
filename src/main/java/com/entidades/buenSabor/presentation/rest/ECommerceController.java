package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.ECommerceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eCommerce")
@CrossOrigin("*")
public class ECommerceController {

    @Autowired
    ECommerceFacade facade;

    @GetMapping("/allArticulos")
    public ResponseEntity<?> all(Pageable pageable){
        return ResponseEntity.ok(facade.getAlllArticulos(pageable));
    }

    @GetMapping("/menoPrecio/{categoriaId}")
    public ResponseEntity<?> filtroByCategoria(@PathVariable Long categoriaId, Pageable pageable){
        return ResponseEntity.ok(facade.findAllOrderByPrecioVentaByCategoriaId(categoriaId, pageable));
    }

    @GetMapping("/allArticulosByCategoriaId{categoriaId}")
    public ResponseEntity<?> allByCategoria(@PathVariable Long categoriaId, Pageable pageable){
        return ResponseEntity.ok(facade.findByCategoriaId(categoriaId, pageable));
    }

    @GetMapping("/menoPrecio")
    public ResponseEntity<?> filtro(Pageable pageable){
        return ResponseEntity.ok(facade.filtroPrecio(pageable));
    }

    @GetMapping("/buscador/{denominacion}")
    public ResponseEntity<?> buscador(@PathVariable String denominacion, Pageable pageable){
        return ResponseEntity.ok(facade.buscador(denominacion, pageable));
    }

    @GetMapping("/getCategorias")
    public ResponseEntity<?> getCategorias(){
        return ResponseEntity.ok(facade.findCategoriasParaVender());
    }

    @GetMapping("/getPromociones")
    public ResponseEntity<?> getPromociones(Pageable pageable){
        return ResponseEntity.ok(facade.findByEliminadoFalseAndHabilitadoTrue(pageable));
    }

    @GetMapping("/buscadorPromociones/{denominacion}")
    public ResponseEntity<?> buscadorPromociones(String denominacion, Pageable pageable){
        return ResponseEntity.ok(facade.findByDenominacionContainingIgnoreCase(denominacion, pageable));
    }
}
