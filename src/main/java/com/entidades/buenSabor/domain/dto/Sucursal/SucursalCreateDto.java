package com.entidades.buenSabor.domain.dto.Sucursal;

import com.entidades.buenSabor.domain.dto.Domicilio.DomicilioCreateDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horarioApertura;

    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horarioCierre;
    private Boolean esCasaMatriz;
    private DomicilioCreateDto domicilio;
    private Long idEmpresa;
}
