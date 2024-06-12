package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.enums.Rol;

import java.util.List;

public interface EmpleadoService extends BaseService<Empleado, Long> {
    Empleado findByEmail(String email);
    int contarPorRol(Rol rol);
    public List<Empleado> findAllBySucursalId(Long id);
}
