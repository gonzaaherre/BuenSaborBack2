package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;

    public boolean tieneStockSuficiente(int cantidad) {
        return stockActual >= cantidad;
    }
}
