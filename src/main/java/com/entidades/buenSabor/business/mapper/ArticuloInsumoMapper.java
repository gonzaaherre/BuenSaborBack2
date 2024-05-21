package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoEditDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoEditDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza.
@Mapper(componentModel = "spring", uses = {UnidadMedidaService.class, ImagenArticuloMapper.class})
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoEditDto> {
    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    ArticuloInsumoMapper INSTANCE = Mappers.getMapper(ArticuloInsumoMapper.class);

    @Named("toDTO")
    ArticuloInsumoDto toDTO(ArticuloInsumo source);

    // Utiliza la anotación @Mapping para especificar el mapeo entre los campos del DTO y la entidad,
    // y utiliza el servicio UnidadMedidaService para obtener la unidad de medida a partir del ID.
    @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById")
    @Mapping(target = "habilitado", constant = "true")
    ArticuloInsumo toEntityCreate(ArticuloInsumoCreateDto source);

    @Mapping(target = "unidadMedida", source = "idUnidadMedida", qualifiedByName = "getById")
    ArticuloInsumo toUpdate(@MappingTarget ArticuloInsumo entity, ArticuloInsumoEditDto source);


}
