package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.domain.dto.EmpresaDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entity.Empresa;
import com.entidades.buenSabor.domain.entity.Sucursal;

public interface EmpresaFacade extends BaseFacade<EmpresaDto, Long> {
}
