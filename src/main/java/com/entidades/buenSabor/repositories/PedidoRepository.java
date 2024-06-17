package com.entidades.buenSabor.repositories;

import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.CostoGanancia;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.IngresosDiarios;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.IngresosMensuales;
import com.entidades.buenSabor.domain.dto.ProyeccionesEstadisticas.PedidosCliente;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long>{
    List<Pedido> findByEstado(Estado estado);
    // mysql -> date(p.fecha_pedido)
    // H2 ->  PARSEDATETIME(p.fecha_pedido, 'yyyy-MM-dd') || FORMATDATETIME(p.fecha_pedido, 'yyyy-MM-dd')

    @Query(value = "SELECT date(p.fecha_pedido) AS fecha, SUM(p.total) AS ingresos " +
            "FROM pedido p " +
            "WHERE p.fecha_pedido BETWEEN :initialDate AND :endDate " +
            "GROUP BY date(p.fecha_pedido)", nativeQuery = true)
    List<IngresosDiarios> ingresosDiarios(Date initialDate, Date endDate);

    // mysql -> date(p.fecha_pedido)
    // H2 ->  PARSEDATETIME(p.fecha_pedido, 'yyyy-MM-dd') || FORMATDATETIME(p.fecha_pedido, 'yyyy-MM-dd')

    @Query(value = "SELECT DATE_FORMAT(p.fecha_pedido, '%Y-%m') AS mes, SUM(p.total) AS ingresos " +
            "FROM Pedido p " +
            "WHERE p.fecha_pedido BETWEEN :startDate AND :endDate " +
            "GROUP BY DATE_FORMAT(p.fecha_pedido, '%Y-%m')", nativeQuery = true)
    List<IngresosMensuales> ingresosMensuales(Date startDate, Date endDate);

    @Query(value = "SELECT " +
            "SUM(dp.cantidad * ai.precioCompra) AS costos, " +
            "SUM(p.total) AS ganancias, " +
            "(SUM(p.total) - SUM(dp.cantidad * ai.precioCompra)) AS resultado " +
            "FROM Pedido p " +
            "JOIN p.detallePedidos dp " +
            "JOIN dp.articulo a " +
            "LEFT JOIN ArticuloInsumo ai ON a.id = ai.id " +
            "WHERE p.fechaPedido BETWEEN :initialDate AND :endDate")
    CostoGanancia findCostosGananciasByFecha(LocalDate initialDate, LocalDate endDate);

    @Query("SELECT p.cliente.email AS email, COUNT(p) AS cantidadPedidos " +
            "FROM Pedido p " +
            "WHERE p.fechaPedido BETWEEN :startDate AND :endDate " +
            "GROUP BY p.cliente.email " +
            "ORDER BY cantidadPedidos DESC")
    List<PedidosCliente> findCantidadPedidosPorCliente(LocalDate startDate, LocalDate endDate);

    List<Pedido> findByClienteId(Long clienteId);

    @Query(value = "SELECT COUNT(p) FROM Pedido p WHERE p.fechaPedido BETWEEN :initialDate AND :endDate")
    Long contarPedidosEnRango(LocalDate initialDate, LocalDate endDate);
}
