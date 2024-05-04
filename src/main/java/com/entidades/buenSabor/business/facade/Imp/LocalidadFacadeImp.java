package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.LocalidadFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.LocalidadService;
import com.entidades.buenSabor.domain.dto.LocalidadDto;
import com.entidades.buenSabor.domain.entity.Localidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadFacadeImp extends BaseFacadeImp<Localidad, LocalidadDto, Long> implements LocalidadFacade {
    public LocalidadFacadeImp(BaseService<Localidad, Long> baseService, BaseMapper<Localidad, LocalidadDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    LocalidadService localidadService;

    @Override
    public List<LocalidadDto> findByProvinciaId(Long id) {
            // trae una lista de entidades
            var entities = localidadService.findByProvinciaId(id);
            //  devuelve una lista de DTO
            return entities
                    .stream()
                    .map(baseMapper::toDTO)
                    .collect(Collectors.toList());
    }
}
