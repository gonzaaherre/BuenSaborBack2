package com.entidades.buenSabor.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder
public class ArticuloManufacturadoDetalle extends Base{

    @ManyToOne
    @JoinColumn(name = "articulomanufacturadodetalle_id")
    private ArticuloManufacturado articuloManufacturado ;


    @ManyToOne
    @JoinColumn(name = "artinsumo_id")
    private ArticuloInsumo articuloInsumo;
}
