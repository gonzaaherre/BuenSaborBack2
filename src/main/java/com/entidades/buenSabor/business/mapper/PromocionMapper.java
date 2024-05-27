package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionCreate;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionEdit;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionShorDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {SucursalService.class, PromocionDetalleMapper.class})
public interface PromocionMapper extends BaseMapper<Promocion,PromocionDto, PromocionCreate, PromocionEdit>{

    public PromocionDto toDTO(Promocion source);
    @Mappings({
            @Mapping(target = "detalles",qualifiedByName = "toEntityCreateSetDetalle"),
            @Mapping(target = "sucursales", source = "idSucursales",qualifiedByName = "getById"),
            @Mapping(target = "habilitado", constant = "true")
    })
    public Promocion toEntityCreate(PromocionCreate source);


    /*
    @Mapping(target = "sucursales", source = "idSucursales")
    Promocion toEntityCreate(PromocionCreate source);
    */
 }
