package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.EmpresaFacadeImpl;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaCreateDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaDto;

import com.entidades.buenSabor.domain.dto.Empresa.EmpresaEditDto;
import com.entidades.buenSabor.domain.dto.Empresa.EmpresaLargeDto;
import com.entidades.buenSabor.domain.entities.Empresa;

import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController extends BaseControllerImp<Empresa, EmpresaDto, EmpresaCreateDto, EmpresaEditDto,Long, EmpresaFacadeImpl> {
    public EmpresaController(EmpresaFacadeImpl facade) {
        super(facade);
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> create(@RequestBody EmpresaCreateDto entity) {
        return super.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EmpresaDto> edit (EmpresaEditDto entity, Long id){
        return super.edit(entity,id);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/sucursales/{idEmpresa}")
    public ResponseEntity<EmpresaLargeDto> getEmpresaSucursales(@PathVariable Long idEmpresa){
        return ResponseEntity.ok(facade.getEmpresaSucursales(idEmpresa));
    }

    // Método POST para subir imágenes
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/uploads")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "uploads", required = true) MultipartFile[] files,
            @RequestParam(value = "id", required = true) Long idEmpresa) {
        try {
            return facade.uploadImages(files, idEmpresa); // Llama al método del servicio para subir imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

    // Método POST para eliminar imágenes por su publicId y Long
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @GetMapping("/getImagesByEmpresaId/{id}")
    public ResponseEntity<?> getAll(@PathVariable Long id) {
        try {
            return facade.getAllImagesByEmpresaId(id); // Llama al método del servicio para obtener todas las imágenes
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Manejo básico de errores, se puede mejorar para devolver una respuesta más específica
        }
    }

}
