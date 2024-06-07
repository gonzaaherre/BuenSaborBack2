package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.EmpleadoFacadeImp;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoEditDto;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/empleado")
public class EmpleadoController extends BaseControllerImp<Empleado, EmpleadoDto, EmpleadoCreateDto, EmpleadoEditDto, Long, EmpleadoFacadeImp> {
    public EmpleadoController(EmpleadoFacadeImp facade) {
        super(facade);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestBody String email){
        return ResponseEntity.ok(facade.findByEmail(email));
    }
}
