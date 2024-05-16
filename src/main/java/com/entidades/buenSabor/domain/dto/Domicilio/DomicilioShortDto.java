package com.entidades.buenSabor.domain.dto.Domicilio;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioShortDto extends BaseDto {
    private String calle;
}
