package com.entidades.buenSabor.utils;

import com.entidades.buenSabor.domain.entities.Localidad;
import com.entidades.buenSabor.domain.entities.Pais;
import com.entidades.buenSabor.domain.entities.Provincia;
import com.entidades.buenSabor.repositories.LocalidadRepository;
import com.entidades.buenSabor.repositories.PaisRepository;
import com.entidades.buenSabor.repositories.ProvinciaRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class LocalidadesDownloader implements CommandLineRunner {

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private PaisRepository paisRepository;
    // Método que se ejecutará al iniciar la aplicación.
    @Override
    public void run(String... args) {
        // Se crea un objeto RestTemplate para realizar solicitudes HTTP.
        RestTemplate restTemplate = new RestTemplate();
        // Se obtiene la respuesta JSON de la URL especificada.
        String jsonResponse = restTemplate.getForObject("https://infra.datos.gob.ar/georef/departamentos.json", String.class);
        // Se crea un objeto JSONObject a partir de la respuesta JSON.
        JSONObject jsonObject = new JSONObject(jsonResponse);
        // Se obtiene el array de departamentos del JSON.
        JSONArray departamentosArray = jsonObject.getJSONArray("departamentos");

// Obtener el país
        Pais pais = paisRepository.findById(1L).orElseGet(() -> {
            Pais newPais = new Pais();
            newPais.setId(1L);
            newPais.setNombre("Argentina");
            return paisRepository.save(newPais);
        });
        // Iterar sobre cada departamento en el array de departamentos.
        departamentosArray.forEach(obj -> {
            JSONObject departamentoJson = (JSONObject) obj;
            // Obtener el ID y nombre de la localidad del departamento.
            Long localidadId = Long.parseLong(departamentoJson.getString("id"));
            String localidadNombre = departamentoJson.getString("nombre");

            // Obtener el JSON de la provincia asociada al departamento.
            JSONObject provinciaJson = departamentoJson.getJSONObject("provincia");
            Long provinciaId = Long.parseLong(provinciaJson.getString("id"));
            String provinciaNombre = provinciaJson.getString("nombre");

            // Verificar si la provincia ya existe por nombre, si no, crearla y guardarla
            Provincia provincia = provinciaRepository.findByNombre(provinciaNombre);
            if (provincia == null) {
                provincia = new Provincia();
                provincia.setId(provinciaId);
                provincia.setNombre(provinciaNombre);
                provincia.setPais(pais);
                provincia = provinciaRepository.save(provincia);
            }
// Crear una nueva localidad con los datos obtenidos y asociarla a la provincia.
            Localidad localidad = new Localidad();
            localidad.setId(localidadId);
            localidad.setNombre(localidadNombre);
            localidad.setProvincia(provincia);
            localidadRepository.save(localidad);
        });
    }
}