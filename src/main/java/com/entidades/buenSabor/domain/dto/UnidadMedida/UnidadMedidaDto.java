package com.entidades.buenSabor.domain.dto.UnidadMedida;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnidadMedidaDto extends BaseDto {
    private String denominacion;
}
