package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long>{

    @Query("SELECT COUNT(p) FROM PromocionDetalle p WHERE p.articulo = :articulo")
    long countByArticulo(@Param("articulo") Articulo articulo);
}
