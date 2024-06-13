package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entities.Cliente;
import com.entidades.buenSabor.domain.entities.Domicilio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    Cliente findByEmail(String email);

    @Query("SELECT d FROM Cliente c JOIN c.domicilios d WHERE c.id = :clienteId")
    List<Domicilio> findAllDomiciliosByClienteId(Long clienteId);
}
