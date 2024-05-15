package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {

    //@Query("SELECT d FROM ArticuloManufacturado d WHERE d.articuloManufacturadoDetalles = :detalle")
    //public List<ArticuloManufacturado> findByArticuloManufacturadoDetalle(@Param("detalle") ArticuloManufacturadoDetalle detalle);
}
