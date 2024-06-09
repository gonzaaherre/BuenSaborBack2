package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.CategoriaFacadeImp;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController extends BaseControllerImp<Categoria, CategoriaDto, CategoriaCreateDto, CategoriaEditDto, Long, CategoriaFacadeImp> {
    public CategoriaController(CategoriaFacadeImp facade) {
        super(facade, "ADMIN");
    }
/*
    @PutMapping("/addInsumo/{idCategoria}/{idInsumo}")
    public ResponseEntity<CategoriaDto> addArticuloInsumo(@PathVariable Long idCategoria, @PathVariable Long idInsumo){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.addInsumo(idCategoria,idInsumo));
    }

    @PutMapping("/addArticuloManufacturado/{idCategoria}/{idArticulo}")
    public ResponseEntity<CategoriaDto> addArticuloManufacturado(@PathVariable Long idCategoria, @PathVariable Long idArticulo){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.addInsumo(idCategoria,idArticulo));
    }
*/
    @PutMapping("/addSubCategoria/{idCategoria}")
    public ResponseEntity<CategoriaDto> addSubCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaCreateDto subCategoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.addSubCategoria(idCategoria,subCategoria));
    }

    @GetMapping("/getCategoriasInsumos")
    public ResponseEntity<?> listCategoriasInsumos(){
        return ResponseEntity.ok(facade.listCategoriaInsumos());
    }

    @GetMapping("/getCategoriasArticulos")
    public ResponseEntity<?> listCategoriasArticulo(){
        return ResponseEntity.ok(facade.listCategoriaArticulos());
    }
}
