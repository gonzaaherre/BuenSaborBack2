package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpleadoService;
import com.entidades.buenSabor.domain.entities.Empleado;
import com.entidades.buenSabor.domain.enums.Rol;
import com.entidades.buenSabor.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImp extends BaseServiceImp<Empleado,Long> implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado findByEmail(String email) {
        return empleadoRepository.findByEmail(email);
    }

    @Override
    public int contarPorRol(Rol rol) {
        return empleadoRepository.countByRol(rol);
    }

    public List<Empleado> findAllBySucursalId(Long id){
        return empleadoRepository.findAllBySucursalId(id);
    }
}
