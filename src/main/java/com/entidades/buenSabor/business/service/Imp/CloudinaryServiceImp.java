package com.entidades.buenSabor.business.service.Imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.entidades.buenSabor.business.service.CloudinaryService;
import jakarta.annotation.Resource;
import org.cloudinary.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CloudinaryServiceImp implements CloudinaryService {

    @Resource
    private Cloudinary cloudinary; // Inyección de dependencia de Cloudinary

    // Método para subir un archivo a Cloudinary
    @Override
    public String uploadFile(MultipartFile file) {
        try {
            HashMap<Object, Object> options = new HashMap<>();
            // Subir el archivo a Cloudinary y obtener la información de la respuesta
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            // Generar la URL segura de la imagen subida
            return cloudinary.url().secure(true).generate(publicId);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para eliminar una imagen de Cloudinary
    @Override
    public ResponseEntity<String> deleteImage(String publicId, Long idBd) {
        try {
            // Eliminar la imagen en Cloudinary
            Map response = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            JSONObject json = new JSONObject(response);

            // Verificar si la eliminación fue exitosa
            if ("ok".equals(json.getString("result"))) {
                // Devolver una respuesta exitosa si la eliminación fue exitosa
                return new ResponseEntity<>("{\"status\":\"OK\", \"message\":\"Image deleted successfully.\"}", HttpStatus.OK);
            } else {
                // Devolver un error si la eliminación no fue exitosa
                return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"Failed to delete image.\"}", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Devolver un error en caso de excepción durante la eliminación
            return new ResponseEntity<>("{\"status\":\"ERROR\", \"message\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

}
