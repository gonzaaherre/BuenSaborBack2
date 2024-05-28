package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.ArticuloRepository;
import com.entidades.buenSabor.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoriaServiceImp extends BaseServiceImp<Categoria, Long> implements CategoriaService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    SucursalService sucursalService;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria addArticulo(Long idCategoria, Long idArticulo) {
        var categoria = baseRepository.getById(idCategoria);
        var articulo = articuloRepository.getById(idArticulo);
        categoria.getArticulos().add(articulo);
        return baseRepository.save(categoria);
    }

    @Override
    public Categoria addSubCategoria(Long idCategoria, Categoria subCategoriaToCreate) {
        var categoria = baseRepository.getById(idCategoria);
        create(subCategoriaToCreate);
        categoria.getSubCategorias().add(subCategoriaToCreate);
        return baseRepository.save(categoria);
    }

    @Override
    public List<Categoria> listCategoriaInsumos() {
        return categoriaRepository.findByEsInsumoTrue();
    }

    @Override
    public List<Categoria> listCategoriaArticulos() {
        return categoriaRepository.findByEsInsumoFalse();
    }

    @Override
    public Categoria create(Categoria request){
        // Se obtienen las sucursales asociadas a la categoría.
        Set<Sucursal> sucursales = request.getSucursales();
        // Asignamos la categoría a cada sucursal y las guardamos
        var entitySaved = baseRepository.save(request);
        sucursales.stream()
                .map(sucursal -> {
                    sucursal.getCategorias().add(request);
                    return sucursal;
                })
                .forEach(sucursalService::create); // Suponiendo que sucursalService tiene un método save para guardar sucursales
        return entitySaved;
    }

}
