package com.entidades.buenSabor.domain.dto.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaCreateDto {
    private String denominacion;

    private Set<Long> idSucursales;

    private boolean esInsumo;
}
