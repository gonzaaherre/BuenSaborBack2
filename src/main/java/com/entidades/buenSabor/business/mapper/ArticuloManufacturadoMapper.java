package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.CategoriaService;
import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoEditDto;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza

@Mapper(componentModel = "spring", uses = {SucursalService.class,ArticuloManufacturadoDetalleMapper.class, UnidadMedidaService.class, ImagenArticuloMapper.class, CategoriaService.class})

public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto,ArticuloManufacturadoEditDto> {

    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    ArticuloManufacturadoMapper INSTANCE = Mappers.getMapper(ArticuloManufacturadoMapper.class);

    @Named("toDTO")
    @Mapping(source = "categoria.denominacion", target = "categoriaNombre")
    @Mapping(source = "sucursal.id", target = "sucursalId")
    ArticuloManufacturadoDto toDTO(ArticuloManufacturado source);

    // Este método define la transformación de un ArticuloManufacturadoCreateDto a una entidad ArticuloManufacturado.
    // Utiliza la anotación @Mappings para especificar múltiples mapeos entre los campos del DTO y la entidad.
    @Mappings({
        @Mapping(target = "articuloManufacturadoDetalles", qualifiedByName = "toEntityCreateSetDetalle"),
            //usamos toEntityCreateSetDetalle para utilizar el mapper de ArticuloManufacturadoDetalle para convertir los detalles a entidad
        @Mapping(target = "unidadMedida", source = "idUnidadMedida",qualifiedByName = "getById"),
            //consumimos el getById para recuperar la unidad de medida de la base de datos
        @Mapping(target = "habilitado", constant = "true"),
            //se utiliza constant ="true" porque mapstruct para los atributos booleanos asigna false por defecto
        @Mapping(target = "categoria", source = "idCategoria", qualifiedByName = "getById"),
            //consumimos el getById para recuperar la categoria de la base de datos
            @Mapping(target = "sucursal",source = "idsucursal",qualifiedByName = "getById")
    })
    // Este método define la transformación de un ArticuloManufacturadoCreateDto a una entidad ArticuloManufacturado.
    public ArticuloManufacturado toEntityCreate(ArticuloManufacturadoCreateDto source);

    @Mapping(target = "articuloManufacturadoDetalles", source = "articuloManufacturadoDetalles",qualifiedByName = "toEntityCreateSetDetalle")
    public ArticuloManufacturado toUpdate(@MappingTarget ArticuloManufacturado entity, ArticuloManufacturadoEditDto source);

    @Named("toDTOCategoria")
    @Mapping(source = "categoria.denominacion", target = "categoriaNombre")
    ArticuloManufacturadoCategoriaDto toDTOCategoria(ArticuloManufacturado source);
}
