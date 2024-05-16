package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.ArticuloManufacturadoDetalleService;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza
@Mapper(componentModel = "spring", uses = {ArticuloManufacturadoDetalleMapper.class, UnidadMedidaService.class, ImagenArticuloMapper.class, ArticuloInsumoService.class})
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto,ArticuloManufacturadoCreateDto> {

    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    ArticuloManufacturadoMapper INSTANCE = Mappers.getMapper(ArticuloManufacturadoMapper.class);

    // Este método define la transformación de un ArticuloManufacturadoCreateDto a una entidad ArticuloManufacturado.
    // Utiliza la anotación @Mappings para especificar múltiples mapeos entre los campos del DTO y la entidad.
    @Mappings({
        @Mapping(target = "articuloManufacturadoDetalles", qualifiedByName = "mapToArticuloManufacturadoDetalleSet"),
        @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById")
    })
    // Este método define la transformación de un ArticuloManufacturadoCreateDto a una entidad ArticuloManufacturado.
    public ArticuloManufacturado toEntityCreate(ArticuloManufacturadoCreateDto source);

    @Mappings({
            @Mapping(target = "articuloManufacturadoDetalles", qualifiedByName = "mapToArticuloManufacturadoDetalleSet" ),
            @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById")
    })
    public ArticuloManufacturado toUpdate(@MappingTarget ArticuloManufacturado entity, ArticuloManufacturadoCreateDto source);

    @Named("mapToArticuloManufacturadoDetalleSet")
    default Set<ArticuloManufacturadoDetalle> mapToArticuloManufacturadoDetalleSet(Set<ArticuloManufacturadoDetalleCreateDto> dtos) {
        return ArticuloManufacturadoDetalleMapper.INSTANCE.toEntityCreateSet(dtos);
    }

}
