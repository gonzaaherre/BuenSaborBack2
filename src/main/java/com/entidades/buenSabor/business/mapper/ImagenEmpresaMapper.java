package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenEditDto;
import com.entidades.buenSabor.domain.entities.ImagenEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImagenEmpresaMapper extends BaseMapper<ImagenEmpresa, ImagenDto, ImagenCreate, ImagenEditDto> {

    @Mapping(source = "url", target = "url")
    public ImagenEmpresa toEntityCreate(ImagenCreate source);
}
