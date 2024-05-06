package com.entidades.buenSabor.repositories;


import com.entidades.buenSabor.domain.entity.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
}
