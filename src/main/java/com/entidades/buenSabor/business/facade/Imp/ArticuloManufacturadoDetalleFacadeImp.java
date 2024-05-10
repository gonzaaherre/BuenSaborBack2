package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloManufacturadoDetalleFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoDetalleFacadeImp extends BaseFacadeImp<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto, Long> implements ArticuloManufacturadoDetalleFacade {
    public ArticuloManufacturadoDetalleFacadeImp(BaseService<ArticuloManufacturadoDetalle, Long> baseService, BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
