package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PaisFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.PaisDto;
import com.entidades.buenSabor.domain.entity.Pais;
import org.springframework.stereotype.Service;


@Service
public class PaisFacadeImp extends BaseFacadeImp<Pais, PaisDto,Long> implements PaisFacade {
    public PaisFacadeImp(BaseService<Pais, Long> baseService, BaseMapper<Pais, PaisDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
