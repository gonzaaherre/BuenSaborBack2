package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.Articulo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository  extends BaseRepository<Articulo, Long> {
}
