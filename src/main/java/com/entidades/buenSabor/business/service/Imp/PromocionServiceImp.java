package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImp extends BaseServiceImp<Promocion, Long> implements PromocionService {

    private static final Logger logger = LoggerFactory.getLogger(PromocionServiceImp.class);

    @Autowired
    SucursalService sucursalService;

    @Override
    public Promocion create(Promocion request){
        var newEntity = baseRepository.save(request);
        newEntity.getSucursales().stream()
                .map(sucursal -> {
                    sucursal.getPromociones().add(request);
                    return sucursal;
                })
                .forEach(sucursalService::create); // Su
        logger.info("Creada entidad {}",newEntity);
        return newEntity;
    }
}
