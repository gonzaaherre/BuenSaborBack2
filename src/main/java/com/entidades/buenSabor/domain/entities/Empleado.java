package com.entidades.buenSabor.domain.entities;

import com.example.buensaboruno.domain.enums.Rol;
    import jakarta.persistence.*;
    import lombok.*;
    import org.hibernate.envers.Audited;
    import org.hibernate.envers.RelationTargetAuditMode;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @Builder
    //@Audited
    public class Empleado extends Persona{


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
