package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.ArticuloInsumo;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {
    List<ArticuloInsumo> findByEliminadoFalseAndHabilitadoTrue();
    List<ArticuloInsumo> findBySucursalId(Long sucursalId);
    Page<ArticuloInsumo> findAll(Pageable pageable);
}
