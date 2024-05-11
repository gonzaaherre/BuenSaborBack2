package com.entidades.buenSabor.domain.dto.Sucursal;

import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalCreateDto {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean esCasaMatriz;
    private DomicilioCreateDto domicilio;
    private Long idEmpresa;
}
