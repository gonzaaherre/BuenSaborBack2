package com.entidades.buenSabor.domain.entities;

import com.entidades.buenSabor.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class Empleado extends Base{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //@OneToOne
    //private Usuario usuario;

    private Rol tipoEmpleado;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REFRESH, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private Set<Pedido> pedidos= new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}
