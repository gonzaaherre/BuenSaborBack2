package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.facade.Imp.ArticuloManufacturadoDetalleFacadeImp;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleEditDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifica
// la clase de servicio que utiliza.
@Mapper(componentModel = "spring", uses = {ArticuloInsumoService.class})
public interface ArticuloManufacturadoDetalleMapper extends BaseMapper<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleDto,ArticuloManufacturadoDetalleCreateDto, ArticuloManufacturadoDetalleEditDto>{

    ArticuloManufacturadoDetalleMapper INSTANCE = Mappers.getMapper(ArticuloManufacturadoDetalleMapper.class);

    @Named("toDTO")
    ArticuloManufacturadoDetalleDto toDTO(ArticuloManufacturadoDetalle source);

    // Utiliza la anotación @Mapping para especificar el mapeo entre los campos del DTO y la entidad,
    // y utiliza el servicio ArticuloInsumoService para obtener el artículo de insumo a partir del ID.
    @Mapping(target = "articuloInsumo", source = "idArticuloInsumo", qualifiedByName = "getById")
    ArticuloManufacturadoDetalle toEntityCreate(ArticuloManufacturadoDetalleCreateDto source);

    @Named("toEntityCreateSetDetalle") //Se asigno el metodo con la anotacion @Named de mapstruct para luego ser usado en ArticuloManufacturadoMapper
    @Mapping(target = "articuloInsumo", source = "idArticuloInsumo", qualifiedByName = "getById")
    Set<ArticuloManufacturadoDetalle> toEntityCreateSet(Set<ArticuloManufacturadoDetalleCreateDto> dtos);
}
