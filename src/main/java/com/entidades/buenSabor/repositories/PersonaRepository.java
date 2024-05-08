package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Persona;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
}
