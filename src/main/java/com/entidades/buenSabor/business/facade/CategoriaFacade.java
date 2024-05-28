package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriaFacade extends BaseFacade<CategoriaDto, CategoriaCreateDto, CategoriaEditDto, Long> {
    public CategoriaDto addInsumo(Long idCategoria, Long idInsumo);
    public CategoriaDto addManufacturado(Long idCategoria, Long idManufacturado);
    public CategoriaDto addSubCategoria(Long idCategoria, CategoriaCreateDto subCategoria);
    public List<CategoriaDto> listCategoriaInsumos();
    public List<CategoriaDto> listCategoriaArticulos();
}
