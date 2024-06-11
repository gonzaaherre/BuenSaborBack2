package com.entidades.buenSabor.domain.dto.PromocionDetalle;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDetalleDto extends BaseDto {
    private int cantidad;
    private ArticuloInsumoCategoriaDto insumo;
    private ArticuloManufacturadoCategoriaDto manufacturado;
}
