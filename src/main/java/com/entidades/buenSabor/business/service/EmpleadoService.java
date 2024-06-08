package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Empleado;


public interface EmpleadoService extends BaseService<Empleado, Long> {
    Empleado findByEmail(String email);
}
