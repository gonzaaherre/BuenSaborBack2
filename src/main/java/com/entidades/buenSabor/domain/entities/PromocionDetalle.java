package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
//@Audited
public class PromocionDetalle extends Base{
    private String detalle;

    @ManyToOne
    private Articulo articulo;
}
