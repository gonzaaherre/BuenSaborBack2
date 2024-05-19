package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;

public interface ArticuloInsumoFacade extends BaseFacade<ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoCreateDto, Long> {
    public void addImagen(ImagenCreate imagen, Long id);
    public void changeHabilitado(Long id);
}
