package com.entidades.buenSabor.domain.dto.Factura;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.enums.FormaPago;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDto extends BaseDto {
    private LocalDate fechaFacturacion;
    private FormaPago formaPago;
    private Double totalVenta;
}
