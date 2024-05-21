package com.entidades.buenSabor.business.facade.Imp;

import com.entidades.buenSabor.business.facade.Base.BaseFacadeImp;
import com.entidades.buenSabor.business.facade.EmpresaFacade;
import com.entidades.buenSabor.business.mapper.BaseMapper;
import com.entidades.buenSabor.business.mapper.EmpresaMapper;
import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.business.service.EmpresaService;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaEditDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class EmpresaFacadeImpl extends BaseFacadeImp<Empresa, EmpresaDto, EmpresaCreateDto, EmpresaEditDto,Long> implements EmpresaFacade {

    public EmpresaFacadeImpl(BaseService<Empresa, Long> baseService, BaseMapper<Empresa, EmpresaDto, EmpresaCreateDto, EmpresaEditDto> baseMapper) {
        super(baseService, baseMapper);
    }


    @Autowired
    EmpresaMapper empresaMapper;

    @Autowired
    EmpresaService empresaService;



    @Override
    public EmpresaLargeDto getEmpresaSucursales(Long idEmpresa) {
        return empresaMapper.toLargeDto(empresaService.getEmpresaSucursales(idEmpresa));
    }

    @Override
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByEmpresaId(Long id) {
        return empresaService.getAllImagesByArticuloId(id);
    }

    @Override
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long id) {
        return empresaService.uploadImages(files,id);
    }

    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        return empresaService.deleteImage(publicId,id);
    }

}
