package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.facade.ArticuloInsumoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.ImagenArticuloMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoFacadeImp extends BaseFacadeImp<ArticuloInsumo, ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoCreateDto, Long> implements ArticuloInsumoFacade {
    public ArticuloInsumoFacadeImp(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDto,ArticuloInsumoCreateDto,ArticuloInsumoCreateDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    ImagenArticuloMapper mapper;
    @Autowired
    ArticuloInsumoService articuloInsumoService;

    @Override
    public void addImagen(ImagenCreate imagen, Long id) {
        articuloInsumoService.addImagen(mapper.toEntityCreate(imagen), id);
    }
}
