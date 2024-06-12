package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.mapper.ImagenArticuloMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.CloudinaryService;
import com.entidades.buenSabor.domain.dto.Articulo.ArticuloDto;
import com.entidades.buenSabor.domain.dto.Articulo.CardArticulo;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.*;

@Service
public class ArticuloInsumoServiceImp extends BaseServiceImp<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    @Autowired
    private PromocionDetalleRepository promocionDetalleRepository;

    @Autowired
    ImagenArticuloRepository imagenArticuloRepository;

    @Autowired
    private CloudinaryService cloudinaryService; // Servicio para interactuar con Cloudinary

    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    ImagenArticuloMapper imagenArticuloMapper;

    @Override
    public void deleteById(Long id) throws RestrictDeleteException {
        var insumo = getById(id);
        List<ArticuloManufacturadoDetalle> detalles = articuloManufacturadoDetalleRepository.findByArticuloInsumo(insumo);
        long detallesPromos = promocionDetalleRepository.countByArticulo(insumo);
       // Si el size de detalles es igual a 0 es porque el insumo no esta en ningun detalle
        if(detalles.size() != 0 || detallesPromos != 0)
            throw new RestrictDeleteException("No se puede eliminar el insumo por la integridad referencial de los datos");
        //si el insumo no esta en ninguno detalle se elimina
        baseRepository.delete(insumo);
    }

    @Override
    public void changeHabilitado(Long id) {
        var articulo = getById(id);
        articulo.setHabilitado(!articulo.isHabilitado());
        baseRepository.save(articulo);
    }

    @Override
    public List<ArticuloInsumo> getAllHabilitados() {
        return articuloInsumoRepository.findByEliminadoFalseAndHabilitadoTrue();
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
        var insumo = baseRepository.getById(idArticulo);
        //por medio de un condicional limitamos la carga de imagenes a un maximo de 3 por aticulo
        //en caso de tratar de excer ese limite arroja un codigo 413 con el mensaje La cantidad maxima de imagenes es 3
        if(insumo.getImagenes().size() >= 3)
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

                //Se asignan las imagenes al insumo
                insumo.getImagenes().add(image);
                //Se guarda la imagen en la base de datos
                imagenArticuloRepository.save(image);
                // Agregar la URL de la imagen a la lista de URLs subidas
                urls.add(image.getUrl());
            }

            //se actualiza el insumo en la base de datos con las imagenes
            baseRepository.save(insumo);

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
    public void decrementStock(Long articuloInsumoId, Integer cantidad) {
        ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(articuloInsumoId)
                .orElseThrow(() -> new RuntimeException("Artículo insumo no encontrado"));
        if (articuloInsumo.getStockActual() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el artículo: " + articuloInsumo.getDenominacion());
        }
        articuloInsumo.setStockActual(articuloInsumo.getStockActual() - cantidad);
        articuloInsumoRepository.save(articuloInsumo);
    }

    @Override
    public List<ArticuloInsumo> findBySucursalId(Long sucursalId) {
        return articuloInsumoRepository.findBySucursalId(sucursalId);
    }
}


