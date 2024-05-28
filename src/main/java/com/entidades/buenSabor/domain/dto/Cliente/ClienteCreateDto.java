package com.entidades.buenSabor.domain.dto.Cliente;

import com.entidades.buenSabor.domain.dto.Pedido.PedidoDto;
import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCreateDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    private LocalDate fechaNacimiento;
    private Rol rol;

    private Set<Long> idPedido;

    private Long idDomicilio;

}
