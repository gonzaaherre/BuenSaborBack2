package com.entidades.buenSabor.domain.entity;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Imagen extends Base{

    private String denominacion;

}
