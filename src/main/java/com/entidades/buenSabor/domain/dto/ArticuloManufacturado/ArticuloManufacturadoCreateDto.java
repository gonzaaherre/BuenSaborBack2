package com.entidades.buenSabor.domain.dto.ArticuloManufacturado;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//dto para crear
public class ArticuloManufacturadoCreateDto {
    private String denominacion;
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private Double precioVenta;
    private String preparacion;
    private Long idUnidadMedida;
    private Set<Long> idsArticuloManufacturadoDetalles;
}
