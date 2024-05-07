package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.DomicilioFacade;
import com.entidades.buenSabor.business.facade.Sucursalfacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.DomicilioDto;
import com.entidades.buenSabor.domain.dto.SucursalDto;
import com.entidades.buenSabor.domain.entity.Domicilio;
import com.entidades.buenSabor.domain.entity.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalFacadeImp extends BaseFacadeImp<Sucursal, SucursalDto,Long> implements Sucursalfacade {
    public SucursalFacadeImp(BaseService<Sucursal, Long> baseService, BaseMapper<Sucursal, SucursalDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    DomicilioFacade domicilioFacade;

//    @Override
//    public SucursalDto createNew(SucursalDto request) {
//        // Convierte a entidad
//        var entityToCreate = baseMapper.toEntity(request);
//
//        // Crea un nuevo domicilio a partir del domicilioDto de la sucursal
//        DomicilioDto domicilioDto = request.getDomicilioDto();
//        DomicilioDto domicilioCreado = domicilioFacade.createNew(domicilioDto);
//
//        // Convierte el DomicilioDto a Domicilio
//        Domicilio domicilio = baseMapper.toEntity(domicilioCreado);
//
//        // Asigna la sucursal al domicilio
//        domicilio.setSucursal(entityToCreate);
//
//        // Asigna el domicilio a la entidad de la sucursal
//        entityToCreate.setDomicilio(domicilio);
//
//        var entityCreated = baseService.create(entityToCreate);
//        // convierte a Dto para devolver
//        return baseMapper.toDTO(entityCreated);
//    }

}
