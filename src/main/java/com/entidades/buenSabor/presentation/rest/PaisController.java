package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PaisFacadeImp;
import com.entidades.buenSabor.domain.dto.Pais.PaisCreateDto;
import com.entidades.buenSabor.domain.dto.Pais.PaisDto;
import com.entidades.buenSabor.domain.entities.Pais;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
@CrossOrigin("*")
public class PaisController extends BaseControllerImp<Pais, PaisDto, PaisCreateDto, PaisCreateDto,Long, PaisFacadeImp> {

    public PaisController(PaisFacadeImp facade) {
        super(facade);
    }
}
