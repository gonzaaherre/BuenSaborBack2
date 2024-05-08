package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.Provincia;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia,Long>{
    Provincia findByNombre(String provinciaNombre);
}
