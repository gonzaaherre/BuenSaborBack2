package com.entidades.buenSabor.domain.dto.DetallePedido;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entities.Articulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDto extends BaseDto {
    private Integer cantidad;
    private Double subTotal;
    private String articuloNombre;
}
