package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entity.Sucursal;

public interface SucursalService  extends BaseService<Sucursal, Long> {
    Sucursal asignarDomicilio(Long id, Long idDomicilio);
}

