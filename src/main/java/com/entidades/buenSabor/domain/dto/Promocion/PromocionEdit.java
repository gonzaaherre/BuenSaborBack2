package com.entidades.buenSabor.domain.dto.Promocion;

import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromocionEdit {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horaDesde;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horaHasta;
    private Double precioPromocional;
    private Set<PromocionDetalleCreate> detalles;
}
