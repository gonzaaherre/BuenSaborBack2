package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.service.ArticuloManufacturadoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import com.entidades.buenSabor.repositories.ImagenArticuloRepository;
import com.entidades.buenSabor.repositories.PromocionDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticuloManufacturadoServiceImp extends BaseServiceImp<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    PromocionDetalleRepository promocionDetalleRepository;

    @Override
    public List<ArticuloManufacturadoDetalle> findAllDetalles(Long id) {
        return getById(id).getArticuloManufacturadoDetalles().stream().toList();
    }

    @Override
    public void changeHabilitado(Long id) {
        var articulo = getById(id);
        articulo.setHabilitado(!articulo.isHabilitado());
        baseRepository.save(articulo);
    }

    @Override
    public List<ArticuloManufacturado> getAllHabilitados() {
        return articuloManufacturadoRepository.findByEliminadoFalseAndHabilitadoTrue();
    }

    @Override
    public void deleteById(Long id) throws RestrictDeleteException {
        var articulo = getById(id);
        long detallesPromos = promocionDetalleRepository.countByArticulo(articulo);
        // Si los detalles son 0 es porque el articulo no esta en ningun detalle
        if(detallesPromos != 0)
            throw new RestrictDeleteException("No se puede eliminar el insumo por la integridad referencial de los datos");
        //si el articulo no esta en ninguno detalle se elimina
        baseRepository.delete(articulo);
    }

    // Método para obtener todas las imágenes almacenadas
    @Override
    //pedimos el id para retornar solo las imagenes de un articulo
    public ResponseEntity<List<Map<String, Object>>> getAllImagesByArticuloId(Long id) {
        try {
            // Consultar todas las imágenes desde la base de datos
            List<ImagenArticulo> images = baseRepository.getById(id).getImagenes().stream().toList();
            List<Map<String, Object>> imageList = new ArrayList<>();

            // Convertir cada imagen en un mapa de atributos para devolver como JSON
            for (ImagenArticulo image : images) {
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
    public ResponseEntity<String> uploadImages(MultipartFile[] files, Long idArticulo) {
        List<String> urls = new ArrayList<>();
        var articuloManufacturado = baseRepository.getById(idArticulo);
        //por medio de un condicional limitamos la carga de imagenes a un maximo de 3 por aticulo
        //en caso de tratar de excer ese limite arroja un codigo 413 con el mensaje La cantidad maxima de imagenes es 3
        if(articuloManufacturado.getImagenes().size() >= 3)
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("La cantidad maxima de imagenes es 3");
        try {
            // Iterar sobre cada archivo recibido
            for (MultipartFile file : files) {
                // Verificar si el archivo está vacío
                if (file.isEmpty()) {
                    return ResponseEntity.badRequest().build();
                }

                // Crear una entidad Image y establecer su nombre y URL (subida a Cloudinary)
                ImagenArticulo image = new ImagenArticulo();
                image.setName(file.getOriginalFilename()); // Establecer el nombre del archivo original
                image.setUrl(cloudinaryService.uploadFile(file)); // Subir el archivo a Cloudinary y obtener la URL

                // Verificar si la URL de la imagen es nula (indicativo de fallo en la subida)
                if (image.getUrl() == null) {
                    return ResponseEntity.badRequest().build();
                }

                //Se asignan las imagenes al articuloManufacturado
                articuloManufacturado.getImagenes().add(image);
                //Se guarda la imagen en la base de datos
                imagenArticuloRepository.save(image);
                // Agregar la URL de la imagen a la lista de URLs subidas
                urls.add(image.getUrl());
            }

            //se actualiza el insumo en la base de datos con las imagenes
            baseRepository.save(articuloManufacturado);

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
            imagenArticuloRepository.deleteById(id);

            // Llamar al servicio de Cloudinary para eliminar la imagen por su publicId
            return cloudinaryService.deleteImage(publicId, id);

        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error (400) si ocurre alguna excepción durante la eliminación
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<ArticuloManufacturado> findBySucursalId(Long sucursalId) {
        return articuloManufacturadoRepository.findBySucursalId(sucursalId);
    }
}
