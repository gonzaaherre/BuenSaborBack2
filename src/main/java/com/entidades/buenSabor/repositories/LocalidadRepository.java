package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entity.Localidad;

import java.util.List;

public interface LocalidadRepository extends BaseRepository<Localidad,Long> {
    List<Localidad> findByProvinciaId(Long id);
}
