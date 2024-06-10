package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImp extends BaseServiceImp<Articulo,Long> implements ArticuloService {
    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImp(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public Articulo findArticuloById(Long id) {
        return articuloRepository.findById(id).orElse(null);
    }
}
