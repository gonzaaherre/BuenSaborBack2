package com.entidades.buenSabor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class DetallePedido extends Base{

    private Integer cantidad;
    private Double subTotal;

    @ManyToOne
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
