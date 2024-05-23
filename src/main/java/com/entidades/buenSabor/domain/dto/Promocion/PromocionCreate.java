package com.entidades.buenSabor.domain.dto.Promocion;

import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.enums.TipoPromocion;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionCreate {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private LocalTime horaDesde;
    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
    private  LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    Set<Long> idSucursales;
    Set<PromocionDetalleCreate> detalles;
}
