package com.entidades.buenSabor.domain.dto.Localidad;

import com.entidades.buenSabor.domain.dto.Provincia.ProvinciaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadCreateDto {
    private String nombre;
    private Long idProvincia;
}
