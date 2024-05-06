package com.entidades.buenSabor.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Domicilio extends Base{

    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private Integer nroDpto;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    @ManyToMany(mappedBy = "domicilios", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Cliente> clientes = new HashSet<>();

    @OneToOne(mappedBy = "domicilio")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "domicilio")
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

}