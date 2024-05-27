package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.PromocionDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionDetalleRepository extends BaseRepository<PromocionDetalle,Long>{
}
