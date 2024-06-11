package com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoDetalleDto extends BaseDto {
    private Integer cantidad;
    private ArticuloInsumoCategoriaDto articuloInsumo;
}
