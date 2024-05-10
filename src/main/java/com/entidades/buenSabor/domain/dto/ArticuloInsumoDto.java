package com.entidades.buenSabor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumoDto extends BaseDto{
    private String denominacion;
    private Double precioVenta;
    private UnidadMedidaDto unidadMedida;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;
}
