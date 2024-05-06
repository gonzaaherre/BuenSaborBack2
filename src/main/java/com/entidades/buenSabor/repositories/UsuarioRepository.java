package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long> {
}
