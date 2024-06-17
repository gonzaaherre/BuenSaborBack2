package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.ECommerceFacade;
import com.entidades.buenSabor.business.mapper.CategoriaMapper;
import com.entidades.buenSabor.business.mapper.PromocionMapper;
import com.entidades.buenSabor.business.service.ECommerceService;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ECommerceFacadeImp implements ECommerceFacade {

    @Autowired
    ECommerceService eCommerceService;

    @Autowired
    CategoriaMapper categoriaMapper;

    @Autowired
    PromocionMapper promocionMapper;

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

    @Override
    public Page<CardArticuloProjection> buscador(String denominacion, Pageable pageable) {
        return eCommerceService.buscador(denominacion,pageable);
    }

    @Override
    public List<CategoriaDto> findCategoriasParaVender() {
        return categoriaMapper.toDTOsList(eCommerceService.findAllCategoriasConArticulosParaVenta());
    }

    @Override
    public Page<PromocionDto> findByEliminadoFalseAndHabilitadoTrue(Pageable pageable) {
        Page<Promocion> promocionesPage = eCommerceService.findByEliminadoFalseAndHabilitadoTrue(pageable);

        // Utiliza el mapper para convertir Promocion a PromocionDto
        List<PromocionDto> promocionDtoList = promocionesPage.getContent().stream()
                .map(promocionMapper::toDTO)
                .collect(Collectors.toList());

        // Crea un page con las promociones ya parseadas a promocionDto
        return new PageImpl<>(promocionDtoList, pageable, promocionesPage.getTotalElements());
    }

    @Override
    public Page<PromocionDto> findByDenominacionContainingIgnoreCase(String denominacion, Pageable pageable) {
        Page<Promocion> promocionesPage = eCommerceService.findByDenominacionContainingIgnoreCase(denominacion, pageable);

        List<PromocionDto> promocionDtoList = promocionesPage.getContent().stream()
                .map(promocionMapper::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(promocionDtoList, pageable, promocionesPage.getTotalElements());
    }
}
