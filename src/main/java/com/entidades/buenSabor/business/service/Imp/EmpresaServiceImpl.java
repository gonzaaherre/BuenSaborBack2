package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpresaService;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl extends BaseServiceImp<Empresa,Long> implements EmpresaService {
}
