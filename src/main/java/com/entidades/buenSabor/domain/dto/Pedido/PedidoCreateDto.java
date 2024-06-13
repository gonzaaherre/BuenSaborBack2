package com.entidades.buenSabor.domain.dto.Pedido;
import com.entidades.buenSabor.domain.dto.DetallePedido.DetallePedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Factura.FacturaCreateDto;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.domain.enums.FormaPago;
import com.entidades.buenSabor.domain.enums.TipoEnvio;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCreateDto {//este va en el post
//    @Schema(type = "string", format = "time", pattern = "HH:mm:ss", description = "Horario de apertura en formato HH:mm:ss")
//    private LocalTime horaEstimadaFinalizacion;
//    private Double total;
//   private Double totalCosto;
//    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate fechaPedido;


   // private Long idSucursal;
   @NotNull
   @Size(min = 1, message = "Un pedido debe tener al menos un detalle de pedido.")
   private Set<DetallePedidoCreateDto> detallePedidos;

    //private Long idSucursal;

    private Long idDomicilio;

    //private FacturaCreateDto factura;

    private Long idCliente;

}
