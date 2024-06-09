package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.FacturaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Factura.FacturaCreateDto;
import com.entidades.buenSabor.domain.dto.Factura.FacturaDto;
import com.entidades.buenSabor.domain.entities.Factura;
import org.springframework.stereotype.Service;

@Service
public class FacturaFacadeImpl extends BaseFacadeImp<Factura, FacturaDto, FacturaCreateDto,FacturaCreateDto,Long> implements FacturaFacade {
    public FacturaFacadeImpl(BaseService<Factura, Long> baseService, BaseMapper<Factura, FacturaDto, FacturaCreateDto, FacturaCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
