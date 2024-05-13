package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.ProvinciaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.ProvinciaService;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaCreateDto;
import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaDto;
import com.entidades.buenSabor.domain.entities.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaFacadeImp extends BaseFacadeImp<Provincia, ProvinciaDto, ProvinciaCreateDto, ProvinciaCreateDto, Long> implements ProvinciaFacade {

    public ProvinciaFacadeImp(BaseService<Provincia, Long> baseService, BaseMapper<Provincia, ProvinciaDto,ProvinciaCreateDto, ProvinciaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    ProvinciaService provinciaService;
    @Override
    public List<ProvinciaDto> findByPaisId(Long id) {
        return baseMapper.toDTOsList(provinciaService.findByPaisId(id));
    }
}
