package com.entidades.buenSabor.domain.dto.Imagen;

import com.entidades.buenSabor.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImagenDto extends BaseDto {
    private String name;
    private String url;
}
