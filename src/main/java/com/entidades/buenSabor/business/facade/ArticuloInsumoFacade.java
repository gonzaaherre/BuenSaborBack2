package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoCreateDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoDto;
import com.entidades.buenSabor.domain.dto.Insumo.ArticuloInsumoEditDto;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ArticuloInsumoFacade extends BaseFacade<ArticuloInsumoDto, ArticuloInsumoCreateDto, ArticuloInsumoEditDto, Long> {
    public void changeHabilitado(Long id);
    public List<ArticuloInsumoDto> getAllHabilitados();

    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);

    List<ArticuloInsumoDto> findBySucursalId(Long sucursalId);
}
