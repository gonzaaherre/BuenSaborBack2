package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//@Audited
public class PromocionDetalle extends Base{
    private String detalle;
}
