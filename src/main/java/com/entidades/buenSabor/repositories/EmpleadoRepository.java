package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.enums.Rol;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    Empleado findByEmail(String email);
    int countByRol(Rol rol);
}
