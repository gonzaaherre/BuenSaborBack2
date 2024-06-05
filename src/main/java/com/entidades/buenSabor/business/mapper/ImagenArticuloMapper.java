package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ImagenArticuloMapper extends BaseMapper<ImagenArticulo, ImagenDto, ImagenDto, ImagenDto> {
    @Named("toDto")
    ImagenDto toDto(ImagenArticulo source);
}
