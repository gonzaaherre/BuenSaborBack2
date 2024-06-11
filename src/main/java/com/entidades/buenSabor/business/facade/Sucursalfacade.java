package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Articulo.ArticuloDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalCreateDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalDto;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalEditDto;
import com.entidades.buenSabor.domain.entities.Articulo;

import java.util.List;

public interface Sucursalfacade extends BaseFacade<SucursalDto, SucursalCreateDto, SucursalEditDto, Long> {
    public List<CategoriaDto> findAllCategoriasByIdSucursal(Long idSucursal);

    public List<PromocionDto> findAllPromocionesBySucursal(Long isSucursal);

    public List<ArticuloDto> getAllArticulosBySucursal(Long sucursalId);

}
