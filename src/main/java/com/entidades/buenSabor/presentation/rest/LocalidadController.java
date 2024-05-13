package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.LocalidadFacadeImp;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadCreateDto;
import com.entidades.buenSabor.domain.dto.Localidad.LocalidadDto;
import com.entidades.buenSabor.domain.entities.Localidad;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidad")
@CrossOrigin("*")
public class LocalidadController extends BaseControllerImp<Localidad, LocalidadDto, LocalidadCreateDto, LocalidadCreateDto,Long, LocalidadFacadeImp> {

    public LocalidadController(LocalidadFacadeImp facade) {
        super(facade);
    }
    private static final Logger logger = LoggerFactory.getLogger(LocalidadController.class);

    @GetMapping("findByProvincia/{idProvincia}")
    public ResponseEntity<List<LocalidadDto>> getByProvincia(@PathVariable Long idProvincia) {
        logger.info("INICIO GET BY PROVINCIA");
        return ResponseEntity.ok(facade.findByProvinciaId(idProvincia));
    }
}
