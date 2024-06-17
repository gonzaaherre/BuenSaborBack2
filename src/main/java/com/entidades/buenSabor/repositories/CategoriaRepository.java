package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long>{
    List<Categoria> findByEsInsumoTrue();
    List<Categoria> findByEsInsumoFalse();
    @Query("SELECT DISTINCT c " +
            "FROM Categoria c " +
            "JOIN FETCH c.articulos a " + //fech para evitar problemas con lazy
            "LEFT JOIN ArticuloInsumo ai ON ai.id = a.id " +
            "WHERE TYPE(a) != com.entidades.buenSabor.domain.entities.ArticuloInsumo " +
            "OR (TYPE(a) = com.entidades.buenSabor.domain.entities.ArticuloInsumo AND ai.esParaElaborar = false)")
    List<Categoria> findAllCategoriasConArticulosParaVenta();
}
