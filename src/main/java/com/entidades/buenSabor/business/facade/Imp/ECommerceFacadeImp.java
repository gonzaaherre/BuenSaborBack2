package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ECommerceFacade;
import com.entidades.buenSabor.business.service.ECommerceService;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ECommerceFacadeImp implements ECommerceFacade {

    @Autowired
    ECommerceService eCommerceService;

    @Override
    public Page<CardArticulo> getAlllArticulos(Pageable pageable) {
        return eCommerceService.allArticulos(pageable);
    }

    @Override
    public Page<CardArticuloProjection> filtroPrecio(Pageable pageable) {
        return eCommerceService.filtroPrecio(pageable);
    }

    @Override
    public Page<CardArticuloProjection> findAllOrderByPrecioVentaByCategoriaId(Long categoriaId, Pageable pageable) {
        return eCommerceService.findAllOrderByPrecioVentaByCategoriaId(categoriaId,pageable);
    }

    @Override
    public Page<CardArticuloProjection> findByCategoriaId(Long categoriaId, Pageable pageable) {
        return eCommerceService.findByCategoriaId(categoriaId, pageable);
    }
}
