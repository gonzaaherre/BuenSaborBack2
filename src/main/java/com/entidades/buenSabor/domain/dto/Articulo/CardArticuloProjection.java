package com.entidades.buenSabor.domain.dto.Articulo;

import java.util.Set;

public interface CardArticuloProjection {
    Long getId();
    String getDenominacion();
    boolean isEsInsumo();
    Double getPrecioVenta();
    Set<String> getImagenUrls();
}