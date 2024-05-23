package com.entidades.buenSabor.domain.dto.PromocionDetalle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDetalleCreate {

    private int cantidad;

    private Long idArticulo;
}
