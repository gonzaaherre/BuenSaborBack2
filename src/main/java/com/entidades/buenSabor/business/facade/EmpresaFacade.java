package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaEditDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenCreate;


public interface EmpresaFacade extends BaseFacade<EmpresaDto, EmpresaCreateDto, EmpresaEditDto, Long> {
    EmpresaLargeDto getEmpresaSucursales(Long idEmpresa);
    void addImagen(ImagenCreate imagen, Long id);
}
