package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entity.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long> {
}
