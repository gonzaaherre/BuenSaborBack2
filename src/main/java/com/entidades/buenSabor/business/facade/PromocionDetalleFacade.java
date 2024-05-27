package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleEdit;

public interface PromocionDetalleFacade extends BaseFacade<PromocionDetalleDto, PromocionDetalleCreate, PromocionDetalleEdit, Long> {
}
