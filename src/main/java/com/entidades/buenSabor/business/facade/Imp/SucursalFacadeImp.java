package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.Sucursalfacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.CategoriaMapper;
import com.entidades.buenSabor.business.mapper.PromocionMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalEditDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalFacadeImp extends BaseFacadeImp<Sucursal, SucursalDto, SucursalCreateDto, SucursalEditDto,Long> implements Sucursalfacade {
    public SucursalFacadeImp(BaseService<Sucursal, Long> baseService, BaseMapper<Sucursal, SucursalDto, SucursalCreateDto, SucursalEditDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    CategoriaMapper categoriaMapper;

    @Autowired
    SucursalService sucursalService;

    @Autowired
    PromocionMapper promocionMapper;

    @Override
    public List<CategoriaDto> findAllCategoriasByIdSucursal(Long idSucursal) {
        return categoriaMapper.toDTOsList(sucursalService.findCategoriasBySucursalId(idSucursal));
    }

    @Override
    public List<PromocionDto> findAllPromocionesBySucursal(Long idSucursal) {
        return promocionMapper.toDTOsList(sucursalService.findPromocionBySucursalId(idSucursal));
    }


}
