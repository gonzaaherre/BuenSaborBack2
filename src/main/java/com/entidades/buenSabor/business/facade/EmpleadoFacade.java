package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoEditDto;

public interface EmpleadoFacade extends BaseFacade<EmpleadoDto, EmpleadoCreateDto, EmpleadoEditDto, Long> {
    EmpleadoDto findByEmail(String email);
}
