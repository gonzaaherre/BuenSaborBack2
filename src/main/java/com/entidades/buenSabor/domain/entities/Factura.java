package com.entidades.buenSabor.domain.entities;


import com.entidades.buenSabor.domain.enums.FormaPago;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Factura extends Base{
    private LocalDate fechaFacturacion;
    //private int numeroFactura;
    private int montoDescuento;
    private FormaPago formaPago;
    private Double totalVenta;



}
