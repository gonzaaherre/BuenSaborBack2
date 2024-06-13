package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.enums.Rol;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    Empleado findByEmail(String email);
    int countByRol(Rol rol);
    List<Empleado> findAllBySucursalId(Long id);
}
