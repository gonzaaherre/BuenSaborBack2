package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ECommerceFacade {
    public Page<CardArticulo> getAlllArticulos(Pageable pageable);
    public Page<CardArticuloProjection> filtroPrecio(Pageable pageable);
    Page<CardArticuloProjection> findAllOrderByPrecioVentaByCategoriaId(Long categoriaId, Pageable pageable);
    Page<CardArticuloProjection> findByCategoriaId(Long categoriaId, Pageable pageable);
    Page<CardArticuloProjection> buscador( String denominacion, Pageable pageable);
    List<CategoriaDto> findCategoriasParaVender();
    public Page<PromocionDto> findByEliminadoFalseAndHabilitadoTrue(Pageable pageable);
    Page<PromocionDto> findByDenominacionContainingIgnoreCase(String denominacion, Pageable pageable);
}
