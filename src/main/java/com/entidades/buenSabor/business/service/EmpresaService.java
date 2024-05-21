package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.domain.entities.ImagenEmpresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface EmpresaService extends BaseService<Empresa, Long> {
    public Empresa getEmpresaSucursales(Long idEmpresa);

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y Long
    ResponseEntity<String> deleteImage(String publicId, Long id);
}
