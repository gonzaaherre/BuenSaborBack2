package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;

public interface EmpleadoFacade extends BaseFacade<EmpleadoDto, EmpleadoCreateDto, EmpleadoCreateDto,Long> {
}
