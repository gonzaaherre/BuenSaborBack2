package com.entidades.buenSabor.domain.dto.Categoria;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.entities.Sucursal;
import lombok.*;


import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto extends BaseDto {
    private String denominacion;

    private Set<Sucursal> sucursales;
}
