package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.domain.entities.ImagenArticulo;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoDetalleRepository;
import com.entidades.buenSabor.repositories.ImagenArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImp extends BaseServiceImp<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    @Autowired
    private ImagenArticuloRepository imagenArticuloRepository;

    @Override
    public void deleteById(Long id) throws RestrictDeleteException {
        var insumo = getById(id);
        List<ArticuloManufacturadoDetalle> detalles = articuloManufacturadoDetalleRepository.findByArticuloInsumo(insumo);
       // Si el size de detalles es igual a 0 es porque el insumo no esta en ningun detalle
        if(detalles.size() != 0)
            throw new RestrictDeleteException("No se puede eliminar el insumo por la integridad referencial de los datos");
        //si el insumo no esta en ninguno detalle se elimina
        baseRepository.delete(insumo);
    }


    @Override
    public void addImagen(ImagenArticulo imagenArticulo, Long id) {
        var articulo = getById(id);
        articulo.getImagenes().add(imagenArticulo);
        imagenArticuloRepository.save(imagenArticulo);
        baseRepository.save(articulo);
    }
}


