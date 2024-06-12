package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoCreateDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturado.ArticuloManufacturadoEditDto;
import com.entidades.buenSabor.domain.dto.ArticuloManufacturadoDetalle.ArticuloManufacturadoDetalleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ArticuloManufacturadoFacade extends BaseFacade<ArticuloManufacturadoDto, ArticuloManufacturadoCreateDto, ArticuloManufacturadoEditDto, Long> {
    List<ArticuloManufacturadoDetalleDto> findAllDetalles(Long id);
    public void changeHabilitado(Long id);
    public List<ArticuloManufacturadoDto> getAllHabilitado();

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);
    List<ArticuloManufacturadoDto> findBySucursalId(Long sucursalId);
}
