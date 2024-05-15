package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.UnidadMedidaService;
import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import com.entidades.buenSabor.repositories.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImp extends BaseServiceImp<UnidadMedida, Long> implements UnidadMedidaService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Override
    public void deleteById(Long id) throws RestrictDeleteException {
        var unidadMedida = getById(id);

        List<Articulo> articulos = articuloRepository.findByUnidadMedida(unidadMedida);
        if(articulos.size() != 0)
            throw new RestrictDeleteException("No se puede eliminar la unidad de medida porque está siendo referenciada por uno o más artículos.");
        baseRepository.delete(unidadMedida);
    }
}
