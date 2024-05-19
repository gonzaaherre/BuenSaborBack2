package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.FacturaService;
import com.entidades.buenSabor.domain.entities.Factura;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImp extends BaseServiceImp<Factura,Long> implements FacturaService {
}
