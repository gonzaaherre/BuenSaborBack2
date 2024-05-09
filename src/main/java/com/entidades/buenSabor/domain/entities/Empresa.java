package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
//@Audited
public class Empresa extends Base{

    private String nombre;
    private String razonSocial;
    private Integer cuil;

    @OneToMany(mappedBy = "empresa",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private Set<Sucursal> Sucursales= new HashSet<>();
}
