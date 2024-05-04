package com.entidades.buenSabor.domain.entity;

import com.entidades.buenSabor.domain.entity.enums.Estado;
import com.entidades.buenSabor.domain.entity.enums.FormaPago;
import com.entidades.buenSabor.domain.entity.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Pedido extends Base{

    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @OneToOne(mappedBy = "pedido")
    private Factura factura;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    @ManyToOne
    private Cliente cliente;


}
