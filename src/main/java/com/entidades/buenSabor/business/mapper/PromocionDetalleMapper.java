package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleEdit;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;


@Mapper(componentModel = "spring", uses = {ArticuloService.class,ArticuloInsumoMapper.class, ArticuloManufacturadoMapper.class})
public interface PromocionDetalleMapper extends BaseMapper<PromocionDetalle, PromocionDetalleDto, PromocionDetalleCreate, PromocionDetalleEdit>{

    PromocionDetalleMapper INSTANCE = Mappers.getMapper(PromocionDetalleMapper.class);

    //este lo usamos para el mapper de promocion
    @Named("toEntityCreateSetDetalle")
    Set<PromocionDetalle> toEntityCreateSetDetalle(Set<PromocionDetalleCreate> dtos);


    //usamos el parametro expression para indicar que vamos a usar un metodo para definir el mapeo
    @Mapping(target = "insumo", expression = "java(filterArticuloInsumo(source))")
    @Mapping(target = "manufacturado", expression = "java(filterArticuloManufacturado(source))")
    public PromocionDetalleDto toDTO(PromocionDetalle source);

    @Mapping(target = "articulo", source = "idArticulo", qualifiedByName = "getById")
    public PromocionDetalle toEntityCreate(PromocionDetalleCreate source);

    // Este método consulta si el articulo es insumo
    default ArticuloInsumoDto filterArticuloInsumo(PromocionDetalle source) {
        return (source.getArticulo() instanceof ArticuloInsumo) ? ArticuloInsumoMapper.INSTANCE.toDTO((ArticuloInsumo) source.getArticulo()) : null;
    }

    // Este método consulta si el articulo es insumo
    default ArticuloManufacturadoDto filterArticuloManufacturado(PromocionDetalle source) {
        return (source.getArticulo() instanceof ArticuloManufacturado) ? ArticuloManufacturadoMapper.INSTANCE.toDTO((ArticuloManufacturado) source.getArticulo()) : null;
    }
}
