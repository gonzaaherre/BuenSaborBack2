package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { PedidoMapper.class, PedidoService.class, DomicilioMapper.class, DomicilioService.class})
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDto, ClienteCreateDto,ClienteCreateDto> {
    //source = de donde viene
    //target = a donde va
    @Mappings({
            //@Mapping(source = "idPedido", target = "pedidos",qualifiedByName = "getById"),
            @Mapping(source = "idDomicilio", target = "domicilios",qualifiedByName = "getById")
    })
    Cliente toEntityCreate(ClienteCreateDto source);
}
