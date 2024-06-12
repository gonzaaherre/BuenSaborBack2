package com.entidades.buenSabor.business.mapper;

import com.entidades.buenSabor.business.service.DomicilioService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteCreateDto;
import com.entidades.buenSabor.domain.dto.Cliente.ClienteDto;
import com.entidades.buenSabor.domain.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { PedidoMapper.class, PedidoService.class, DomicilioMapper.class})
public interface ClienteMapper extends BaseMapper<Cliente, ClienteDto, ClienteCreateDto,ClienteCreateDto> {
    //source = de donde viene
    //target = a donde va
    @Mappings({
//            //@Mapping(source = "idPedido", target = "pedidos",qualifiedByName = "getById"),
            @Mapping(source = "domicilios", target = "domicilios",qualifiedByName = "toEntityCreateSetDomicilio"),
            @Mapping(source = "imagenUrl", target = "imagenCliente.url"), // creamos un objeto Imagen cliente con la url recibida
            @Mapping(source = "email",target = "imagenCliente.name") // le asignamos como nombre el email del usuario
    })
    Cliente toEntityCreate(ClienteCreateDto source);

}
