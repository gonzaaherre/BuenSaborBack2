package com.entidades.buenSabor.domain.dto.Cliente;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    private LocalDate fechaNacimiento;

    //private Set<PedidoDto> pedidos = new HashSet<>();

    private Set<DomicilioDto> domicilios;

    private ImagenDto imagenCliente;
}
