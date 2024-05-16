package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entities.Articulo;
import com.entidades.buenSabor.domain.entities.UnidadMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository  extends BaseRepository<Articulo, Long> {
    // Método para buscar artículos por unidad de medida.
    List<Articulo> findByUnidadMedida(UnidadMedida unidadMedida);
}
