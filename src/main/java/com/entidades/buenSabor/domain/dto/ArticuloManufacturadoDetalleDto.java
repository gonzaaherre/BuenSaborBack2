package com.entidades.buenSabor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoDetalleDto extends BaseDto{
    private Integer cantidad;
    private ArticuloInsumoDto articuloInsumo;
}
