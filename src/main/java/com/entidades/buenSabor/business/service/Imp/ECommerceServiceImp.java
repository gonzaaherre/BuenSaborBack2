package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ECommerceService;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ECommerceServiceImp implements ECommerceService {
    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;
    @Autowired
    ArticuloRepository articuloRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    PromocionRepository promocionRepository;

    @Override
    public Page<CardArticulo> allArticulos(Pageable pageable) {
        List<CardArticulo> articulos = new ArrayList<>();

        // Obtener la página de artículos insumo
        Page<ArticuloInsumo> pageArticuloInsumo = articuloInsumoRepository.findAll(pageable);
        for (ArticuloInsumo ai : pageArticuloInsumo.getContent()) {
            if(!ai.getEsParaElaborar()) {
                CardArticulo ar = new CardArticulo();
                ar.setId(ai.getId());
                ar.setDenominacion(ai.getDenominacion());
                ar.setEsInsumo(true);
                for (ImagenArticulo i : ai.getImagenes()) {
                    ar.getImagenes().add(i.getUrl());
                }
                ar.setPrecioVenta(ai.getPrecioVenta());
                articulos.add(ar);
            }
        }

        // Obtener la página de artículos manufacturados
        Page<ArticuloManufacturado> pageArticuloManufacturado = articuloManufacturadoRepository.findAll(pageable);
        for (ArticuloManufacturado am : pageArticuloManufacturado.getContent()) {
            CardArticulo ar = new CardArticulo();
            ar.setId(am.getId());
            ar.setDenominacion(am.getDenominacion());
            ar.setEsInsumo(false);
            for (ImagenArticulo i : am.getImagenes()) {
                ar.getImagenes().add(i.getUrl());
            }
            ar.setPrecioVenta(am.getPrecioVenta());
            articulos.add(ar);
        }

        // Combinar las listas de artículos insumo y manufacturados en una sola página
        return new PageImpl<>(articulos, pageable, pageArticuloInsumo.getTotalElements() + pageArticuloManufacturado.getTotalElements());
    }

    @Override
    public Page<CardArticuloProjection> filtroPrecio(Pageable pageable) {
        return articuloRepository.findAllOrderByPrecioVenta(pageable);
    }

    @Override
    public Page<CardArticuloProjection> findAllOrderByPrecioVentaByCategoriaId(Long categoriaId, Pageable pageable) {
        return articuloRepository.findAllOrderByPrecioVentaByCategoriaId(categoriaId, pageable);
    }

    @Override
    public Page<CardArticuloProjection> findByCategoriaId(Long categoriaId, Pageable pageable) {
        return articuloRepository.findByCategoriaId(categoriaId, pageable);
    }

    @Override
    public Page<CardArticuloProjection> buscador(String denominacion, Pageable pageable) {
        return articuloRepository.findByDenominacionContaining(denominacion, pageable);
    }

    @Override
    public List<Categoria> findAllCategoriasConArticulosParaVenta() {
        return categoriaRepository.findAllCategoriasConArticulosParaVenta();
    }

    @Override
    public Page<Promocion> findByEliminadoFalseAndHabilitadoTrue(Pageable pageable) {
        return promocionRepository.findByEliminadoFalseAndHabilitadoTrue(pageable);
    }

    @Override
    public Page<Promocion> findByDenominacionContainingIgnoreCase(String denominacion, Pageable pageable) {
        return promocionRepository.findByDenominacionContainingIgnoreCase(denominacion,pageable);
    }


}
