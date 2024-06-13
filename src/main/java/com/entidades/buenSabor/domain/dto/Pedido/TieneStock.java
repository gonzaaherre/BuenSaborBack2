package com.entidades.buenSabor.domain.dto.Pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TieneStock {
    public boolean stock;
    public String nombreArticulo;
}
