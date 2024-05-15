package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {
    public void addImagen(ImagenArticulo imagenArticulo, Long id);
}
