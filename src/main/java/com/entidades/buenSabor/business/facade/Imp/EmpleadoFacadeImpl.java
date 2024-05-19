package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpleadoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.entities.Empleado;

public class EmpleadoFacadeImpl extends BaseFacadeImp<Empleado, EmpleadoDto, EmpleadoCreateDto,EmpleadoCreateDto,Long> implements EmpleadoFacade {
    public EmpleadoFacadeImpl(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoDto, EmpleadoCreateDto, EmpleadoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
