package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entity.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long> {
}
