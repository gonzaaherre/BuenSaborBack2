package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.UnidadMedidaFacadeImp;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadDeMedidaEditDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaCreateDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaDto;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UnidadMedida")
@CrossOrigin("*")
public class UnidadMedidaController extends BaseControllerImp<UnidadMedida, UnidadMedidaDto, UnidadMedidaCreateDto, UnidadDeMedidaEditDto,Long, UnidadMedidaFacadeImp> {
    public UnidadMedidaController(UnidadMedidaFacadeImp facade) {
        super(facade);
    }
}
