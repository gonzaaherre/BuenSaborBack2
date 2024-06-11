package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ArticuloInsumoFacade;
import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoEditDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

@Service
public class ArticuloInsumoFacadeImp extends BaseFacadeImp<ArticuloInsumo, ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoEditDto, Long> implements ArticuloInsumoFacade {

    @Autowired
    ArticuloInsumoService articuloInsumoService;

    public ArticuloInsumoFacadeImp(BaseService<ArticuloInsumo, Long> baseService, BaseMapper<ArticuloInsumo, ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoEditDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Override
    public void changeHabilitado(Long id) {
        articuloInsumoService.changeHabilitado(id);
    }

    @Override
    public List<ArticuloInsumoDto> getAllHabilitados() {
        return baseMapper.toDTOsList(articuloInsumoService.getAllHabilitados());
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
        return articuloInsumoService.getAllImagesByArticuloId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return articuloInsumoService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return articuloInsumoService.deleteImage(publicId, id);
    }


    @Override
    public List<ArticuloInsumoDto> findBySucursalId(Long sucursalId) {
        return baseMapper.toDTOsList(articuloInsumoService.findBySucursalId(sucursalId));
    }
}
