package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpleadoFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.EmpleadoService;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoCreateDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoDto;
import com.entidades.buenSabor.domain.dto.Empleado.EmpleadoEditDto;
import com.entidades.buenSabor.domain.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoFacadeImp extends BaseFacadeImp<Empleado, EmpleadoDto, EmpleadoCreateDto, EmpleadoEditDto, Long> implements EmpleadoFacade {
    public EmpleadoFacadeImp(BaseService<Empleado, Long> baseService, BaseMapper<Empleado, EmpleadoDto, EmpleadoCreateDto, EmpleadoEditDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public EmpleadoDto findByEmail(String email) {
        return baseMapper.toDTO(empleadoService.findByEmail(email));
    }

    public List<EmpleadoDto> findAllBySucursalId(Long id) {
        return baseMapper.toDTOsList(empleadoService.findAllBySucursalId(id));
    }
}
