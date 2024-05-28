package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.PromocionFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.PromocionDetalleMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.PromocionService;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionCreate;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionEdit;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PromocionFacadeImp extends BaseFacadeImp<Promocion, PromocionDto, PromocionCreate, PromocionEdit, Long> implements PromocionFacade {
    public PromocionFacadeImp(BaseService<Promocion, Long> baseService, BaseMapper<Promocion, PromocionDto, PromocionCreate, PromocionEdit> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    PromocionService promocionService;

    @Autowired
    PromocionDetalleMapper promocionDetalleMapper;

    public void changeHabilitado(Long id) {
        promocionService.changeHabilitado(id);
    }
    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id) {
        return promocionService.getAllImagesByPromocionId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return promocionService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return promocionService.deleteImage(publicId, id);
    }

    @Override
    public List<PromocionDetalleDto> findPromocionWithDetalles(Long promocionId) {
        return promocionDetalleMapper.toDTOsList(promocionService.getPromocionWithDetalles(promocionId));
    }

    @Override
    public List<PromocionDto> getAllActiveNow() {
        return baseMapper.toDTOsList(promocionService.getAllActiveNow());
    }

    @Override
    public List<PromocionDto> getHabilitadas() {
        return baseMapper.toDTOsList(promocionService.getAllHabilitados());
    }
}
