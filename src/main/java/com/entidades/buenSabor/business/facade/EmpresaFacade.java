package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;

import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.EmpresaLargeDto;


public interface EmpresaFacade extends BaseFacade<EmpresaDto, Long> {
    EmpresaLargeDto getEmpresaSucursales(Long idEmpresa);
}
