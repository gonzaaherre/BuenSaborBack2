package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenEditDto;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImagenArticuloMapper extends BaseMapper<ImagenArticulo, ImagenDto, ImagenCreate, ImagenEditDto> {

    @Mapping(source = "url", target = "url")
    public ImagenArticulo toEntityCreate(ImagenCreate source);
}
