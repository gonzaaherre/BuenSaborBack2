package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.CategoriaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaFacadeImp extends BaseFacadeImp<Categoria, CategoriaDto, CategoriaCreateDto, CategoriaEditDto, Long> implements CategoriaFacade {
    public CategoriaFacadeImp(BaseService<Categoria, Long> baseService, BaseMapper<Categoria, CategoriaDto, CategoriaCreateDto, CategoriaEditDto> baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public CategoriaDto addInsumo(Long idCategoria, Long idInsumo) {
        return baseMapper.toDTO(categoriaService.addArticulo(idCategoria,idInsumo));
    }

    @Override
    public CategoriaDto addManufacturado(Long idCategoria, Long idManufacturado) {
        return baseMapper.toDTO(categoriaService.addArticulo(idCategoria,idManufacturado));
    }

    @Override
    public CategoriaDto addSubCategoria(Long idCategoria, CategoriaCreateDto subCategoria) {
        Categoria subCategoriaToCreate = baseMapper.toEntityCreate(subCategoria);
        return baseMapper.toDTO(categoriaService.addSubCategoria(idCategoria, subCategoriaToCreate));
    }

    @Override
    public List<CategoriaDto> listCategoriaInsumos() {
        return baseMapper.toDTOsList(categoriaService.listCategoriaInsumos());
    }

    @Override
    public List<CategoriaDto> listCategoriaArticulos() {
        return baseMapper.toDTOsList(categoriaService.listCategoriaArticulos());
    }
}
