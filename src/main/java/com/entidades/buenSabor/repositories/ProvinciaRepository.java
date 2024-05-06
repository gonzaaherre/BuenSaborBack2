package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entity.Provincia;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia,Long> {
    Provincia findByNombre(String nombre);
}
