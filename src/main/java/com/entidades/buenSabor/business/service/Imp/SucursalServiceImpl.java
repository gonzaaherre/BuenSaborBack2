package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl extends BaseServiceImp<Sucursal,Long> implements SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    public List<Categoria> findCategoriasBySucursalId(Long idSucursal) {
        return sucursalRepository.findWithCategoriasById(idSucursal).getCategorias().stream().toList();
    }

    @Override
    public List<Promocion> findPromocionBySucursalId(Long idSucursal) {
        return sucursalRepository.findWithPromocionesById(idSucursal).getPromociones().stream().toList();
    }


}
