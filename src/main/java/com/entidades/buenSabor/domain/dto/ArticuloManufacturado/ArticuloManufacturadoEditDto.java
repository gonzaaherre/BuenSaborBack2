package com.entidades.buenSabor.domain.dto.ArticuloManufacturado;

import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleEditDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoEditDto {

    private String descripcion;
    private Double precioVenta;
    private String preparacion;
    private Integer tiempoEstimadoMinutos;
    private Set<ArticuloManufacturadoDetalleCreateDto> detalles;
}
