package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaEditDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface EmpresaFacade extends BaseFacade<EmpresaDto, EmpresaCreateDto, EmpresaEditDto, Long> {
    EmpresaLargeDto getEmpresaSucursales(Long idEmpresa);

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByEmpresaId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);
}
