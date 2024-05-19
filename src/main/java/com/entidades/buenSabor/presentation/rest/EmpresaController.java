package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.EmpresaFacadeImpl;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaEditDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.entities.Empresa;

import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController extends BaseControllerImp<Empresa, EmpresaDto, EmpresaCreateDto, EmpresaEditDto,Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade) {
        super(facade);
    }

    @GetMapping("/sucursales/{idEmpresa}")
    public ResponseEntity<EmpresaLargeDto> getEmpresaSucursales(@PathVariable Long idEmpresa){
        return ResponseEntity.ok(facade.getEmpresaSucursales(idEmpresa));
    }

    @PutMapping("/addImagen/{id}")
    public ResponseEntity<?> addImagen(@PathVariable Long id, @RequestBody ImagenCreate imagen){
        facade.addImagen(imagen,id);
        return ResponseEntity.ok("Imagen agregada con exito");
    }
}
