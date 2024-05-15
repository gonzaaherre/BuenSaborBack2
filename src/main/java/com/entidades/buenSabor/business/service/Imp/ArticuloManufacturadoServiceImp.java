package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloManufacturadoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImp extends BaseServiceImp<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Override
    public List<ArticuloManufacturadoDetalle> findAllDetalles(Long id) {
        return getById(id).getArticuloManufacturadoDetalles().stream().toList();
    }
}
