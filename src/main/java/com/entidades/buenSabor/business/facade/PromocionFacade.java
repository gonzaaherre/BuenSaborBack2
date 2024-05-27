package com.entidades.buenSabor.business.facade;

import com.entidades.buenSabor.business.facade.Base.BaseFacade;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionCreate;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionEdit;
import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PromocionFacade extends BaseFacade<PromocionDto, PromocionCreate, PromocionEdit, Long> {
    public void changeHabilitado(Long id);
    //Imagenes
    // Método para obtener todas las imágenes almacenadas
    ResponseEntity<List<Map<String, Object>>> getAllImagesByPromocionId(Long id);
    // Método para subir imágenes al sistema
    ResponseEntity<String> uploadImages(MultipartFile[] files, Long id);
    // Método para eliminar una imagen por su identificador público y UUID
    ResponseEntity<String> deleteImage(String publicId, Long id);
    Optional<Promocion> findPromocionWithDetalles(Long promocionId);

}
