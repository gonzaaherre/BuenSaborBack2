package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Articulo.ArticuloDto;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.repositories.ArticuloInsumoRepository;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import com.entidades.buenSabor.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalServiceImpl extends BaseServiceImp<Sucursal,Long> implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Override
    public List<Categoria> findCategoriasBySucursalId(Long idSucursal) {
        return sucursalRepository.findWithCategoriasById(idSucursal).getCategorias().stream().toList();
    }

    @Override
    public List<Promocion> findPromocionBySucursalId(Long idSucursal) {
        return sucursalRepository.findWithPromocionesById(idSucursal).getPromociones().stream().toList();
    }

    public List<ArticuloInsumo> getArticuloInsumosBySucursal(Long sucursalId) {
        return articuloInsumoRepository.findBySucursalId(sucursalId);
    }

    public List<ArticuloManufacturado> getArticuloManufacturadosBySucursal(Long sucursalId) {
        return articuloManufacturadoRepository.findBySucursalId(sucursalId);
    }

    public List<ArticuloDto> getAllArticulosBySucursal(Long sucursalId) {
        List<ArticuloDto> articulos = new ArrayList<>();
        for (ArticuloInsumo ai : getArticuloInsumosBySucursal(sucursalId)){
            ArticuloDto ar = new ArticuloDto();
            ar.setId(ai.getId());
            ar.setDenominacion(ai.getDenominacion());
            articulos.add(ar);
        }

        for (ArticuloManufacturado am : getArticuloManufacturadosBySucursal(sucursalId)){
            ArticuloDto ar = new ArticuloDto();
            ar.setId(am.getId());
            ar.setDenominacion(am.getDenominacion());
            articulos.add(ar);
        }

        return articulos;
    }

}
