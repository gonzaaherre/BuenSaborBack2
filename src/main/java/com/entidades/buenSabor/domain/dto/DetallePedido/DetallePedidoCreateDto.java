package com.entidades.buenSabor.domain.dto.DetallePedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoCreateDto {

    private Integer cantidad;
    private Double subTotal;
}
