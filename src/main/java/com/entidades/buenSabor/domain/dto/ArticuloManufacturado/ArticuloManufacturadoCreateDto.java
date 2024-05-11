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
public class ArticuloManufacturadoCreateDto {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private Long unidadMedida;
    private Set<Long> idsArticuloManufacturadoDetalles;
}
