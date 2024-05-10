package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.ArticuloManufacturadoFacade;
import com.entidades.buenSabor.business.facade.Imp.ArticuloManufacturadoFacadeImp;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/ArticuloManufacturado")
public class ArticuloManufacturadoController extends BaseControllerImp<ArticuloManufacturado, ArticuloManufacturadoDto, Long, ArticuloManufacturadoFacadeImp> {
    public ArticuloManufacturadoController(ArticuloManufacturadoFacadeImp facade) {
        super(facade);
    }
}
