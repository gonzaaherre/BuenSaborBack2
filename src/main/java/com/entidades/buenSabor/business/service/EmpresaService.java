package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entity.Empresa;
import com.entidades.buenSabor.domain.entity.Sucursal;

public interface EmpresaService extends BaseService<Empresa, Long> {
    public Empresa addSucursal(Long idEmpresa, Long idSucursal);
}
