package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpresaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.EmpresaMapper;
import com.entidades.buenSabor.business.mapper.ImagenEmpresaMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.EmpresaService;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;
import com.entidades.buenSabor.domain.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaFacadeImpl extends BaseFacadeImp<Empresa, EmpresaDto, EmpresaCreateDto, EmpresaCreateDto,Long> implements EmpresaFacade {

    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaDto,EmpresaCreateDto, EmpresaCreateDto>baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    EmpresaMapper empresaMapper;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    ImagenEmpresaMapper imagenEmpresaMapper;

    @Override
    public EmpresaLargeDto getEmpresaSucursales(Long idEmpresa) {
        return empresaMapper.toLargeDto(empresaService.getEmpresaSucursales(idEmpresa));
    }

    @Override
    public void addImagen(ImagenCreate imagen, Long id) {
        empresaService.setImagen(imagenEmpresaMapper.toEntityCreate(imagen), id);
    }
}
