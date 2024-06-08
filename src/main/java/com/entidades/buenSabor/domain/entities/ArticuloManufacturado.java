package com.entidades.buenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class ArticuloManufacturado extends Articulo{

    @Column(length = 510)
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    @Column(length = 510)
    private String preparacion;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "articuloManufacturado_id")
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();

    public Boolean hayStock(){
        Integer cantidad = 0;
        for (ArticuloManufacturadoDetalle detalle: articuloManufacturadoDetalles) {
            cantidad = detalle.getCantidad();
            if (detalle.getArticuloInsumo().getStockActual() < cantidad)
                return false;
        }
        return true;
    }

    public Double precioCostoCalculado(){
        Double precioCosto = 0.0;
        for (ArticuloManufacturadoDetalle detalle : articuloManufacturadoDetalles ){
            precioCosto += detalle.getArticuloInsumo().getPrecioCompra();
        }
        return precioCosto;
    }

}
