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
public class Provincia extends Base{

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
}
