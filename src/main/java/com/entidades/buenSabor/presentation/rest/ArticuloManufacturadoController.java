package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.ArticuloManufacturadoFacadeImp;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ArticuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImp<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto, ArticuloManufacturadoCreateDto, Long, ArticuloManufacturadoFacadeImp> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/allDetalles/{id}")
    public ResponseEntity<?> findAllDetalle(@PathVariable Long id){
        return ResponseEntity.ok(facade.findAllDetalles(id));
    }

    @PutMapping("/addImagen/{id}")
    public ResponseEntity<?> addImagen(@PathVariable Long id, @RequestBody ImagenCreate imagen){
        facade.addImagen(imagen, id);
        return ResponseEntity.ok().body("Imagen cargada");
    }

    @PutMapping("/changeHabilitado/{id}")
    public ResponseEntity<?> changeHabilitado(@PathVariable Long id){
        facade.changeHabilitado(id);
        return ResponseEntity.ok().body("Se cambio el estado del Insuomo");
    }

}
