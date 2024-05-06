package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.entity.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {
}
