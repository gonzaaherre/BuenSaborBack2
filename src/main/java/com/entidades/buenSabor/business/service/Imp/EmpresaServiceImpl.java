package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.business.service.EmpresaService;

import com.entidades.buenSabor.business.service.SucursalService;
import com.entidades.buenSabor.domain.entities.Empresa;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.domain.entities.ImagenEmpresa;
import com.entidades.buenSabor.domain.entities.Sucursal;
import com.entidades.buenSabor.repositories.EmpresaRepository;
import com.entidades.buenSabor.repositories.ImagenEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl extends BaseServiceImp<Empresa,Long> implements EmpresaService {

    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    ImagenEmpresaRepository imagenEmpresaRepository;
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public Empresa getEmpresaSucursales(Long idEmpresa) {
        Empresa empresa = baseRepository.getById(idEmpresa);
        // Se filtran las sucursales eliminadas y se juntan
        Set<Sucursal> sucursales = empresa.getSucursales().stream()
                .filter(sucursal -> !sucursal.isEliminado())
                .collect(Collectors.toSet());
        // Se actualiza el conjunto de sucursales de la empresa.
        empresa.setSucursales(sucursales);
        return empresa;
    }

    // Método para obtener todas las imágenes almacenadas
    @Override
    //pedimos el id para retornar solo las imagenes de un articulo
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
        try {
            // Consultar todas las imágenes desde la base de datos
            List<ImagenEmpresa> images = baseRepository.getById(id).getImagenes().stream().toList();
            List<Map<String, Object>> imageList = new ArrayList<>();

            // Convertir cada imagen en un mapa de atributos para devolver como JSON
            for (ImagenEmpresa image : images) {
                Map<String, Object> imageMap = new HashMap<>();
                imageMap.put("id", image.getId());
                imageMap.put("name", image.getName());
                imageMap.put("url", image.getUrl());
                imageList.add(imageMap);
            }

            // Devolver la lista de imágenes como ResponseEntity con estado OK (200)
            return ResponseEntity.ok(imageList);
        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error interno del servidor (500) si ocurre alguna excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    // Método para subir imágenes a Cloudinary y guardar los detalles en la base de datos
    @Override
    //Pedimos el id de articulo para saber a que articulo asignar las imagenes
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long IdEmpresa) {
        List<String> urls = new ArrayList<>();
        var empresa = baseRepository.getById(IdEmpresa);
        //por medio de un condicional limitamos la carga de imagenes a un maximo de 3 por aticulo
        //en caso de tratar de excer ese limite arroja un codigo 413 con el mensaje La cantidad maxima de imagenes es 3
        if(empresa.getImagenes().size() >= 3)
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("La cantidad maxima de imagenes es 3");
        try {
            // Iterar sobre cada archivo recibido
            for (MultipartFile file : files) {
                // Verificar si el archivo está vacío
                if (file.isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }

                // Crear una entidad Image y establecer su nombre y URL (subida a Cloudinary)
                ImagenEmpresa image = new ImagenEmpresa();
                image.setName(file.getOriginalFilename()); // Establecer el nombre del archivo original
                image.setUrl(cloudinaryService.uploadFile(file)); // Subir el archivo a Cloudinary y obtener la URL

                // Verificar si la URL de la imagen es nula (indicativo de fallo en la subida)
                if (image.getUrl() == null) {
                    return ResponseEntity.badRequest().build();
                }

                //Se asignan las imagenes a la empresa
                empresa.getImagenes().add(image);
                //Se guarda la imagen en la base de datos
                imagenEmpresaRepository.save(image);
                // Agregar la URL de la imagen a la lista de URLs subidas
                urls.add(image.getUrl());
            }

            //se actualiza la empresa en la base de datos con las imagenes
            baseRepository.save(empresa);

            // Convertir la lista de URLs a un objeto JSON y devolver como ResponseEntity con estado OK (200)
            return new ResponseEntity<>("{\"status\":\"OK\", \"urls\":" + urls + "}", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante el proceso de subida
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    // Método para eliminar una imagen por su identificador en la base de datos y en Cloudinary
    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long id) {
        try {
            // Eliminar la imagen de la base de datos usando su identificador
            imagenEmpresaRepository.deleteById(id);

            // Llamar al servicio de Cloudinary para eliminar la imagen por su publicId
            return cloudinaryService.deleteImage(publicId, id);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante la eliminación
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
