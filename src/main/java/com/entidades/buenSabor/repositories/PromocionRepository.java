package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Promocion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PromocionRepository extends BaseRepository<Promocion,Long>{
    @Query("SELECT p FROM Promocion p LEFT JOIN FETCH p.sucursales WHERE p.id = :id")
    Promocion findAllWithSucursales(@Param("id") Long id);

    @Query("SELECT p FROM Promocion p LEFT JOIN FETCH p.detalles WHERE p.id = :promocionId")
    Optional<Promocion> findPromocionWithDetalles(@Param("promocionId") Long promocionId);


    //Por medio de esta query traemos una lista con todas las promociones activas en el dia "X" a la hora "Y"
    @Query("SELECT p FROM Promocion p WHERE " +
            "p.eliminado = false AND " +
            "p.habilitado = true AND " +
            "p.fechaDesde <= :currentDate AND " +
            "p.fechaHasta >= :currentDate AND " +
            "p.horaDesde <= :currentTime AND " +
            "p.horaHasta >= :currentTime")
    List<Promocion> findActivePromociones(LocalDate currentDate, LocalTime currentTime);

    List<Promocion> findByEliminadoFalseAndHabilitadoTrue();

    Page<Promocion> findByEliminadoFalseAndHabilitadoTrue(Pageable pageable);

    //ContainingIgnoreCase para que ignore mayusculas
    Page<Promocion> findByDenominacionContainingIgnoreCase(String denominacion, Pageable pageable);
}
