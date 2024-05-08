package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ImagenPersona extends Base{
    private String url;
}
