package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Provincia extends Base {
    private String nombre;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Pais pais;

}
