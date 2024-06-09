package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    Cliente findByEmail(String email);
}
