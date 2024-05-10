package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Empresa;

public interface EmpresaService extends BaseService<Empresa, Long> {
    public Empresa getEmpresaSucursales(Long idEmpresa);
}
