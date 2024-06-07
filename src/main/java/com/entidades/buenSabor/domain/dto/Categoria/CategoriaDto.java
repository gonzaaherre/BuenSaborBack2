package com.entidades.buenSabor.domain.dto.Categoria;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.Sucursal.ShortSucursal;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalShortShort;
import com.entidades.buenSabor.domain.entities.Sucursal;
import lombok.*;


import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto extends BaseDto {
    private String denominacion;

    private boolean esInsumo;

    private Set<SucursalShortShort> sucursales;

    private Set<SubCategoriaDto> subCategorias;

    private Set<ArticuloInsumoCategoriaDto> insumos;

    private Set<ArticuloManufacturadoCategoriaDto> articulosManufacturados;

}
