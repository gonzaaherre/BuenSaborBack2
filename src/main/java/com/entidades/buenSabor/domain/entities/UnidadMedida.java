package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
//@Audited
public class UnidadMedida extends Base{

    private String denominacion;

}
