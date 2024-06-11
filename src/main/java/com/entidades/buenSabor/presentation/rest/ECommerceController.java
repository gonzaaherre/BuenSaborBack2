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

}
