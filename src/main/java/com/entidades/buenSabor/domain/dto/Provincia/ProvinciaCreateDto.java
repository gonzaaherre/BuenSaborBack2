package com.entidades.buenSabor.domain.dto.Provincia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaCreateDto {
    private String nombre;
    private Long idPais;
}
