package com.entidades.buenSabor.domain.dto.ArticuloManufacturado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoEditDto {

    private Long idUnidadMedida;
    private Double precioVenta;
}
