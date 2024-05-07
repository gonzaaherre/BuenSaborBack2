package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.DomicilioFacade;
import com.entidades.buenSabor.business.facade.LocalidadFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.LocalidadMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.LocalidadService;
import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.entity.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioFacadeImp extends BaseFacadeImp<Domicilio, DomicilioDto, Long> implements DomicilioFacade {
    public DomicilioFacadeImp(BaseService<Domicilio, Long> baseService, BaseMapper<Domicilio, DomicilioDto> baseMapper) {
        super(baseService, baseMapper);
    }

}
