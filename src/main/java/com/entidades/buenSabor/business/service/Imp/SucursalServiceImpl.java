package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entity.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl extends BaseServiceImp<Sucursal,Long> implements SucursalService {
}
