package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.service.ArticuloManufacturadoDetalleService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoDetalleRepository;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoDetalleServiceImp extends BaseServiceImp<ArticuloManufacturadoDetalle, Long> implements ArticuloManufacturadoDetalleService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Override
    public void deleteById(Long id) throws RestrictDeleteException {
        var articuloManufacturadoDetalle = getById(id);

        List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.findByArticuloManufacturadoDetalles(articuloManufacturadoDetalle);
        // Si el size de articulos es igual a 0 es porque el insumo no esta en ningun detalle
        if(articulos.size() != 0)
            throw new RestrictDeleteException("No se puede eliminar el detalle por la integridad referencial de los datos");
        //si el articuloManufacturado no esta en ninguno detalle se elimina
        baseRepository.delete(articuloManufacturadoDetalle);
    }
}
