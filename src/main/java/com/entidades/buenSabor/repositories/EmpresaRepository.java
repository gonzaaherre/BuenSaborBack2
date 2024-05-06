package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entity.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends BaseRepository<Empresa,Long> {
}
