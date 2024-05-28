package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Categoria;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria, Long> {
    public Categoria addArticulo(Long idCategoria, Long idArticulo);
    public Categoria addSubCategoria(Long idCategoria, Categoria subCategoriaToCreate);
    public List<Categoria> listCategoriaInsumos();
    public List<Categoria> listCategoriaArticulos();
}
