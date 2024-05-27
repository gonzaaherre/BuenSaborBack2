package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Categoria;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.Sucursal;

import java.util.List;

public interface SucursalService  extends BaseService<Sucursal, Long> {
    public List<Categoria> findCategoriasBySucursalId(Long idSucursal);

    public List<Promocion> findPromocionBySucursalId(Long idSucursal);


}

