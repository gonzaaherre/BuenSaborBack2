package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle,Long> {

    @Query("SELECT d FROM ArticuloManufacturadoDetalle d WHERE d.articuloInsumo = :insumo")
    List<ArticuloManufacturadoDetalle> findByArticuloInsumo(@Param("insumo") ArticuloInsumo insumo);
}
