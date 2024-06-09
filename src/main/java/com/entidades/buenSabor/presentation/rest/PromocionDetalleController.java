package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PromocionDetalleFacadeImp;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleEdit;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/promocionDetalle")
@CrossOrigin("*")
public class PromocionDetalleController extends BaseControllerImp<PromocionDetalle, PromocionDetalleDto, PromocionDetalleCreate, PromocionDetalleEdit,Long, PromocionDetalleFacadeImp> {
    public PromocionDetalleController(PromocionDetalleFacadeImp facade) {
        super(facade);
    }
}
