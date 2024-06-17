package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ECommerceService {
    public Page<CardArticulo> allArticulos(Pageable pageable);
    public Page<CardArticuloProjection> filtroPrecio(Pageable pageable);
    Page<CardArticuloProjection> findAllOrderByPrecioVentaByCategoriaId(Long categoriaId, Pageable pageable);
    Page<CardArticuloProjection> findByCategoriaId(Long categoriaId, Pageable pageable);
    Page<CardArticuloProjection> buscador (String denominacion, Pageable pageable);
    List<Categoria> findAllCategoriasConArticulosParaVenta();
    Page<Promocion> findByEliminadoFalseAndHabilitadoTrue(Pageable pageable);
    Page<Promocion> findByDenominacionContainingIgnoreCase(String denominacion, Pageable pageable);
}
