package com.entidades.buenSabor.domain.entity;

import com.entidades.buenSabor.domain.entity.enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Factura extends Base{

    private LocalDate fechaFacturacion;
    private Integer mpPaymentId;
    private Integer mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private Double totalVenta;

    @OneToOne
    private Pedido pedido;

}
