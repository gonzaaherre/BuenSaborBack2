package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.PromocionFacadeImp;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionCreate;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionDto;
import com.entidades.buenSabor.domain.dto.Promocion.PromocionEdit;
import com.entidades.buenSabor.domain.dto.PromocionDetalle.PromocionDetalleCreate;
import com.entidades.buenSabor.domain.entities.Promocion;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping("/promocion")
@RestController
public class PromocionController extends BaseControllerImp<Promocion, PromocionDto, PromocionCreate, PromocionEdit, Long, PromocionFacadeImp> {
    public PromocionController(PromocionFacadeImp facade) {
        super(facade);
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<?> create(PromocionCreate entity){
        return super.create(entity);
    }

    @Override
    @PutMapping("/{id}")
     @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<PromocionDto> edit(PromocionEdit edit, Long id){
        return super.edit(edit, id);
    }

    @PutMapping("/detalles/{id}")
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    public ResponseEntity<PromocionDto> editDetalles(@RequestBody Set<PromocionDetalleCreate> detalles,@PathVariable Long id){
        return ResponseEntity.ok(facade.editDetalles(detalles, id));
    }

    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    @PutMapping("/changeHabilitado/{id}")
    public ResponseEntity<?> changeHabilitado(@PathVariable Long id){
        facade.changeHabilitado(id);
        return ResponseEntity.ok("Cambio realizado con exito");
    }

    @GetMapping("/getAllActiveNow")
    public ResponseEntity<?> getAllActiveNow(){
        return ResponseEntity.ok(facade.getAllActiveNow());
    }

    @GetMapping("/getHabilitadas")
    public ResponseEntity<?> getHabilitados(){
        return ResponseEntity.ok(facade.getHabilitadas());
    }

    // Método POST para subir imágenes
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idPromocion) {
        try {
            return facade.uploadImages(files, idPromocion); // Llama al método del servicio para subir imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    // Método POST para eliminar imágenes por su publicId y Long
    @PreAuthorize("hasAnyAuthority('EMPLEADO','ADMIN')")
    @PostMapping("/deleteImg")
    public ResponseEntity<String> deleteById(
            @RequestParam(value = "publicId", required = true) String publicId,
            @RequestParam(value = "id", required = true) Long id) {
        try {
            return facade.deleteImage(publicId, id); // Llama al método del servicio para eliminar la imagen
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid UUID format"); // Respuesta HTTP 400 si el UUID no es válido
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred"); // Respuesta HTTP 500 si ocurre un error inesperado
        }
    }

    // Método GET para obtener todas las imágenes almacenadas
    @GetMapping("/getImagesByArticuloId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByPromocionId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }


    @GetMapping("/getDetallesByid/{id}")
    public ResponseEntity<?> getAllDetalles(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facade.findPromocionWithDetalles(id)); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }
}
