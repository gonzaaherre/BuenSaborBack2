package com.entidades.buenSabor.domain.dto.Insumo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloInsumoEditDto {

    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;
}
