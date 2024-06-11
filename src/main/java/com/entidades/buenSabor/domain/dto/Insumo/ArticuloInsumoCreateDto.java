package com.entidades.buenSabor.domain.dto.Insumo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloInsumoCreateDto {
    private String denominacion;
    private Double precioVenta;
    private Long idUnidadMedida;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;
    private Long idCategoria;
    private Long idSucursal;
}
