package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.dto.Articulo.CardArticuloProjection;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

@Repository
public interface ArticuloRepository  extends BaseRepository<Articulo, Long> {
    // Método para buscar artículos por unidad de medida.
    List<Articulo> findByUnidadMedida(UnidadMedida unidadMedida);
    @Query("SELECT a.id AS id, a.denominacion AS denominacion, " +
            "CASE WHEN TYPE(a) = com.entidades.buenSabor.domain.entities.ArticuloInsumo THEN true ELSE false END AS esInsumo, " +
            "a.precioVenta AS precioVenta, " +
            "i.url AS imagenUrls " +
            "FROM Articulo a LEFT JOIN a.imagenes i " +
            "ORDER BY a.precioVenta ASC")
    Page<CardArticuloProjection> findAllOrderByPrecioVenta(Pageable pageable);
}
