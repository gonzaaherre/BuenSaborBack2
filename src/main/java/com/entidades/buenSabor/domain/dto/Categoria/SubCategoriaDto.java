package com.entidades.buenSabor.domain.dto.Categoria;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoriaDto extends BaseDto {
    private String denominacion;

    private boolean esInsumo;
}
