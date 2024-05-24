package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.entities.ImagenEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagenEmpresaMapper extends BaseMapper<ImagenEmpresa, ImagenDto, ImagenDto,ImagenDto> {
}
