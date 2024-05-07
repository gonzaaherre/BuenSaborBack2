package com.entidades.buenSabor.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Localidad extends Base{

    private String nombre;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

}
