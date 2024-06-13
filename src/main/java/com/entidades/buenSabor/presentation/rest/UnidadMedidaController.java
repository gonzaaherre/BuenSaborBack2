package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UnidadMedidaFacadeImp;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadDeMedidaEditDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UnidadMedida")
@CrossOrigin("*")
public class UnidadMedidaController extends BaseControllerImp<UnidadMedida, UnidadMedidaDto, UnidadMedidaCreateDto, UnidadDeMedidaEditDto,Long, UnidadMedidaFacadeImp> {
    public UnidadMedidaController(UnidadMedidaFacadeImp facade) {
        super(facade);
    }

    @PostMapping
    @Override
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<?> create(UnidadMedidaCreateDto entity){
        return super.create(entity);
    }

    @PutMapping("/{id}")
    @Override
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<UnidadMedidaDto> edit(UnidadDeMedidaEditDto edit, Long id){
        return super.edit(edit,id);
    }
}
