package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaCreateDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaDto;
import com.entidades.buenSabor.domain.dto.Categoria.CategoriaEditDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {SucursalService.class, ArticuloInsumoMapper.class, ArticuloManufacturadoMapper.class, SucursalMapper.class})
public interface CategoriaMapper extends BaseMapper<Categoria, CategoriaDto,CategoriaCreateDto, CategoriaEditDto> {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    @Mapping(target = "sucursales", source = "idSucursales",qualifiedByName = "getById")
    Categoria toEntityCreate(CategoriaCreateDto source);


    @Mapping(target = "insumos", expression = "java(filterArticulosInsumo(source))")
    @Mapping(target = "articulosManufacturados", expression = "java(filterArticulosManufacturados(source))")
    CategoriaDto toDTO(Categoria source);

    default Set<ArticuloInsumoDto> filterArticulosInsumo(Categoria source) {
        return source.getArticulos().stream()
                .filter(articulo -> articulo instanceof ArticuloInsumo)
                .map(articulo -> ArticuloInsumoMapper.INSTANCE.toDTO((ArticuloInsumo) articulo))
                .collect(Collectors.toSet());
    }

    default Set<ArticuloManufacturadoDto> filterArticulosManufacturados(Categoria source) {
        return source.getArticulos().stream()
                .filter(articulo -> articulo instanceof ArticuloManufacturado)
                .map(articulo -> ArticuloManufacturadoMapper.INSTANCE.toDTO((ArticuloManufacturado) articulo))
                .collect(Collectors.toSet());
    }

}
