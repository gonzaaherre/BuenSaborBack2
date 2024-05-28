package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.ArticuloManufacturado;
import com.entidades.buenSabor.domain.entities.ArticuloManufacturadoDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {
    // Método para buscar artículos manufacturados por detalles de artículo manufacturado dado.
    List<ArticuloManufacturado> findByArticuloManufacturadoDetalles(ArticuloManufacturadoDetalle detalleId);
    List<ArticuloManufacturado> findByEliminadoFalseAndHabilitadoTrue();
}
