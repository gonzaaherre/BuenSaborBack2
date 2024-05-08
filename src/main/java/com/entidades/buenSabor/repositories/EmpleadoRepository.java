package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
}
