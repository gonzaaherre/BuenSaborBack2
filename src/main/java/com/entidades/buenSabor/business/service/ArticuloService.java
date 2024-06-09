package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Articulo;

public interface ArticuloService extends BaseService<Articulo,Long> {

    Articulo findArticuloById(Long id);
}
