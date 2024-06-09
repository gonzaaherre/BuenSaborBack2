package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCategoriaDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCategoriaDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

// En este caso, se utiliza el componente "spring" para la inyección de dependencias y se especifican
// las clases de servicio y mappers que utiliza.
@Mapper(componentModel = "spring", uses = {SucursalService.class, ArticuloInsumoMapper.class,
        ArticuloManufacturadoMapper.class, SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDto,CategoriaCreateDto, CategoriaEditDto> {
    // Esta es una instancia estática de la interfaz, que se utiliza para obtener una instancia del Mapper.
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    // Este método define la transformación de un CategoriaCreateDto a una entidad Categoria.
    @Mapping(target = "sucursales", source = "idSucursales",qualifiedByName = "getById")
    Categoria toEntityCreate(CategoriaCreateDto source);


    //usamos el parametro expression para indicar que vamos a usar un metodo para definir el mapeo
    @Mapping(target = "insumos", expression = "java(filterArticulosInsumo(source))")
    @Mapping(target = "articulosManufacturados", expression = "java(filterArticulosManufacturados(source))")
    CategoriaDto toDTO(Categoria source);

    // Este método filtra y mapea los artículos de insumo de la categoría
    @Named("filterArticulosInsumo")
    default Set<ArticuloInsumoCategoriaDto> filterArticulosInsumo(Categoria source) {
        return source.getArticulos().stream()
                .filter(articulo -> articulo instanceof ArticuloInsumo)
                .map(articulo -> ArticuloInsumoMapper.INSTANCE.toDTOCategoria((ArticuloInsumo) articulo))
                .collect(Collectors.toSet());
    }

    // Este método filtra y mapea los artículos manufacturados de la categoría.
    @Named("filterArticulosManufacturados")
    default Set<ArticuloManufacturadoCategoriaDto> filterArticulosManufacturados(Categoria source) {
        return source.getArticulos().stream()
                .filter(articulo -> articulo instanceof ArticuloManufacturado)
                .map(articulo -> ArticuloManufacturadoMapper.INSTANCE.toDTOCategoria((ArticuloManufacturado) articulo))
                .collect(Collectors.toSet());
    }

}
