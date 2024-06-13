package com.entidades.buenSabor.presentation.rest;


import com.entidades.buenSabor.business.facade.Imp.SucursalFacadeImp;

import com.entidades.buenSabor.domain.dto.Articulo.ArticuloDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalDto;

import com.entidades.buenSabor.domain.dto.Sucursal.SucursalEditDto;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin("*")
public class SucursalController extends BaseControllerImp<Sucursal, SucursalDto, SucursalCreateDto, SucursalEditDto,Long, SucursalFacadeImp> {
    public SucursalController(SucursalFacadeImp facade) {
        super(facade);
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> create(SucursalCreateDto entity){
        return super.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SucursalDto> edit (SucursalEditDto entity, Long id){
        return super.edit(entity, id);
    }


    @GetMapping("/getCategorias/{idSucursal}")
    public ResponseEntity<List<CategoriaDto>>getCategorias(@PathVariable Long idSucursal){
        return ResponseEntity.ok(facade.findAllCategoriasByIdSucursal(idSucursal));
    }

    @GetMapping("/getPromociones/{idSucursal}")
    public ResponseEntity<List<PromocionDto>>getPromociones(@PathVariable Long idSucursal){
        return ResponseEntity.ok(facade.findAllPromocionesBySucursal(idSucursal));
    }

    @GetMapping("/{sucursalId}/articulos")
    public ResponseEntity<List<ArticuloDto>> getAllArticulosBySucursal(@PathVariable Long sucursalId) {
        List<ArticuloDto> articulos = facade.getAllArticulosBySucursal(sucursalId);
        return ResponseEntity.ok(articulos);
    }
}
