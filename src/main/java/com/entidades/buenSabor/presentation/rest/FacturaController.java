package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.FacturaFacadeImpl;
import com.entidades.buenSabor.domain.dto.Factura.FacturaCreateDto;
import com.entidades.buenSabor.domain.dto.Factura.FacturaDto;
import com.entidades.buenSabor.domain.entities.Factura;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturas")
@CrossOrigin("*")
public class FacturaController extends BaseControllerImp<Factura, FacturaDto, FacturaCreateDto,FacturaCreateDto, Long, FacturaFacadeImpl> {

    public FacturaController(FacturaFacadeImpl facade) {
        super(facade,"");
    }
}
