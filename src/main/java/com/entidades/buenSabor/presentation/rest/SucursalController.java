package com.entidades.buenSabor.presentation.rest;


import com.entidades.buenSabor.business.facade.Imp.SucursalFacadeImp;

import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalDto;

import com.entidades.buenSabor.domain.dto.Sucursal.SucursalEditDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin("*")
public class SucursalController extends BaseControllerImp<Sucursal, SucursalDto, SucursalCreateDto, SucursalEditDto,Long, SucursalFacadeImp> {
    public SucursalController(SucursalFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/getCategorias/{idSucursal}")
    public ResponseEntity<List<CategoriaDto>>getCategorias(@PathVariable Long idSucursal){
        return ResponseEntity.ok(facade.findAllCategoriasByIdSucursal(idSucursal));
    }

    @GetMapping("/getPromociones/{idSucursal}")
    public ResponseEntity<List<PromocionDto>>getPromociones(@PathVariable Long idSucursal){
        return ResponseEntity.ok(facade.findAllPromocionesBySucursal(idSucursal));
    }
}
