package com.entidades.buenSabor.domain.dto.Promocion;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleDto;
import com.entidades.buenSabor.domain.dto.Sucursal.ShortSucursal;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalShortShort;
import com.entidades.buenSabor.domain.enums.TipoPromocion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PromocionDto extends BaseDto {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private  LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    Set<SucursalShortShort> sucursales;
    Set<PromocionDetalleDto> detalles;
    private Boolean habilitado;
    private Set<ImagenDto> imagenes;
}
