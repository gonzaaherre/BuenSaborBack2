package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ProvinciaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.ProvinciaDto;
import com.entidades.buenSabor.domain.entity.Provincia;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaFacadeImp extends BaseFacadeImp<Provincia, ProvinciaDto, Long> implements ProvinciaFacade {

    public ProvinciaFacadeImp(BaseService<Provincia, Long> baseService, BaseMapper<Provincia, ProvinciaDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
