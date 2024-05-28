package com.entidades.buenSabor.domain.dto;

import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SucursalDto extends BaseDto {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Boolean esCasaMatriz;
    private DomicilioDto domicilio;
    private EmpresaDto empresa;
}