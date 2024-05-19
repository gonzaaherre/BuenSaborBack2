package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloManufacturadoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.ArticuloManufacturadoDetalleMapper;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.ImagenArticuloMapper;
import com.entidades.buenSabor.business.service.ArticuloManufacturadoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoEditDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoFacadeImp extends BaseFacadeImp<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto, ArticuloManufacturadoEditDto, Long> implements ArticuloManufacturadoFacade {


    @Autowired
    ArticuloManufacturadoService articuloManufacturadoService;

    @Autowired
    ArticuloManufacturadoDetalleMapper articuloManufacturadoDetalleMapper;

    @Autowired
    ImagenArticuloMapper mapper;

    public ArticuloManufacturadoFacadeImp(BaseService<ArticuloManufacturado, Long> baseService, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto, ArticuloManufacturadoEditDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoDetalleDto> findAllDetalles(Long id) {
        return articuloManufacturadoDetalleMapper.toDTOsList(articuloManufacturadoService.findAllDetalles(id));
    }

    @Override
    public void addImagen(ImagenCreate imagen, Long id) {
        articuloManufacturadoService.addImagen(mapper.toEntityCreate(imagen), id);
    }

    @Override
    public void changeHabilitado(Long id) {
        articuloManufacturadoService.changeHabilitado(id);
    }
}
