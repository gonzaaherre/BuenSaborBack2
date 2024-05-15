package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoDetalleRepository;
import com.entidades.buenSabor.repositories.ArticuloManufacturadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImp extends BaseServiceImp<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
    //@Autowired
    //private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Override
    public void deleteById(Long id) {
        //le sacamos el if
        var insumo = getById(id);

        //eliminamos logicamente
        insumo.setEliminado(true);
        baseRepository.save(insumo);

        // a cada insumo del manufacturado le ponemos null
        List<ArticuloManufacturadoDetalle> detalles = articuloManufacturadoDetalleRepository.findByArticuloInsumo(insumo);
        for (ArticuloManufacturadoDetalle detalle : detalles) {
            /*List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.findByArticuloManufacturadoDetalle(detalle);
            for (ArticuloManufacturado articulo : articulos) {
                articulo.setArticuloManufacturadoDetalles(null);
            }*/
            detalle.setArticuloInsumo(null);
            // Actualizamos
            articuloManufacturadoDetalleRepository.save(detalle);
        }
    }


}


