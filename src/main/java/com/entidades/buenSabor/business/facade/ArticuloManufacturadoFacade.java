package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;

import java.util.List;

public interface ArticuloManufacturadoFacade extends BaseFacade<ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto, ArticuloManufacturadoCreateDto, Long> {
    List<ArticuloManufacturadoDetalleDto> findAllDetalles(Long id);
    public void addImagen(ImagenCreate imagen, Long id);
    public void changeHabilitado(Long id);
}
