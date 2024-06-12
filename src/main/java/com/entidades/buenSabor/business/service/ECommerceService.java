package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ECommerceService {
    public Page<CardArticulo> allArticulos(Pageable pageable);
    public Page<CardArticuloProjection> filtroPrecio(Pageable pageable);
    Page<CardArticuloProjection> findAllOrderByPrecioVentaByCategoriaId(Long categoriaId, Pageable pageable);
    Page<CardArticuloProjection> findByCategoriaId(Long categoriaId, Pageable pageable);
}
