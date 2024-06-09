package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.DomicilioFacadeImp;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioEditDto;
import com.entidades.buenSabor.domain.entities.Domicilio;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domicilio")
@CrossOrigin("*")
public class DomicilioController extends BaseControllerImp<Domicilio, DomicilioDto, DomicilioCreateDto, DomicilioEditDto,Long, DomicilioFacadeImp> {
    public DomicilioController(DomicilioFacadeImp facade) {
        super(facade);
    }
}
