package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpresaService;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl extends BaseServiceImp<Empresa,Long> implements EmpresaService {

    @Override
    public Empresa getEmpresaSucursales(Long idEmpresa) {
        Empresa empresa = baseRepository.getById(idEmpresa);
        // Se filtran las sucursales eliminadas y se juntan
        Set<Sucursal> sucursales = empresa.getSucursales().stream()
                .filter(sucursal -> !sucursal.isEliminado())
                .collect(Collectors.toSet());
        // Se actualiza el conjunto de sucursales de la empresa.
        empresa.setSucursales(sucursales);
        return empresa;
    }
}
