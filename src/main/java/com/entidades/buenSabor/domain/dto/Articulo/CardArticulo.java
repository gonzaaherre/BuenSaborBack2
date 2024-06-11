package com.entidades.buenSabor.domain.dto.Articulo;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardArticulo extends BaseDto {
    String denominacion;
    boolean esInsumo;
    Set<String> imagenes = new HashSet<>();
    Double precioVenta;
}
