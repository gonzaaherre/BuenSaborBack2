package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpleadoService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.domain.enums.Rol;
import com.entidades.buenSabor.domain.enums.TipoEnvio;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class PedidoServiceImp extends BaseServiceImp<Pedido,Long> implements PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private ArticuloInsumoService articuloInsumoService;
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    EmpleadoService empleadoService;

    @Override
    public Pedido create(Pedido pedido) {
        // Asignar sucursal desde el artículo del pedido
        if (!pedido.getDetallePedidos().isEmpty()) {
            Articulo articulo = pedido.getDetallePedidos().iterator().next().getArticulo();
            if (articulo != null && articulo.getSucursal() != null) {
                pedido.setSucursal(articulo.getSucursal());
            }
        }
        pedido.setEstado(Estado.PREPARACION);
        validarStock(pedido.getDetallePedidos());
        aplicarDescuento(pedido);
        calcularTiempoEstimado(pedido);
        return super.create(pedido);
    }

    @Override
    public void validarStock(Set<DetallePedido> detalles) {
        for (DetallePedido detalle : detalles) {
            Articulo articulo = detalle.getArticulo();
            if (articulo instanceof ArticuloInsumo) {
                ArticuloInsumo insumo = (ArticuloInsumo) articulo;
                if (!insumo.tieneStockSuficiente(detalle.getCantidad())) {
                    throw new RuntimeException("Stock insuficiente para el artículo: " + insumo.getDenominacion());
                }
                // Decrementar el stock
                insumo.setStockActual(insumo.getStockActual() - detalle.getCantidad());
                articuloService.update(insumo, insumo.getId());
            }
        }
    }

    @Override
    public void aplicarDescuento(Pedido pedido) {
        if (pedido.getTipoEnvio() == TipoEnvio.TAKE_AWAY) {
            pedido.setTotal(pedido.getTotal() * 0.9); // Aplicar 10% de descuento
        }
    }

    @Override
    public void calcularTiempoEstimado(Pedido pedido) {
        int tiempoArticulos = pedido.getDetallePedidos().stream()
                .mapToInt(detalle -> {
                    if (detalle.getArticulo() instanceof ArticuloManufacturado) {
                        ArticuloManufacturado articuloManufacturado = (ArticuloManufacturado) detalle.getArticulo();
                        return articuloManufacturado.getTiempoEstimadoMinutos();
                    } else {
                        return 0;
                    }
                })
                .sum();
        int tiempoCocina = obtenerPedidosEnCocina().stream()
                .flatMap(p -> p.getDetallePedidos().stream())
                .mapToInt(detalle -> {
                    if (detalle.getArticulo() instanceof ArticuloManufacturado) {
                        ArticuloManufacturado articuloManufacturado = (ArticuloManufacturado) detalle.getArticulo();
                        return articuloManufacturado.getTiempoEstimadoMinutos();
                    } else {
                        return 0;
                    }
                })
                .sum();

        int cantidadCocineros = contarCocineros();
        int tiempoCocinaPromedio = cantidadCocineros > 0 ? tiempoCocina / cantidadCocineros : 0;

        int tiempoDelivery = pedido.getTipoEnvio() == TipoEnvio.DELIVERY ? 10 : 0;
        pedido.setHoraEstimadaFinalizacion(LocalTime.now().plusMinutes(tiempoArticulos + tiempoCocinaPromedio + tiempoDelivery));
    }

    @Override
    public List<Pedido> obtenerPedidosEnCocina() {
        // Implementar la lógica para obtener los pedidos que están en preparación
        return pedidoRepository.findByEstado(Estado.PREPARACION);
    }

    @Override
    public int contarCocineros() {
        return empleadoService.contarPorRol(Rol.COCINERO);
    }

    @Override
    public Pedido cambiaEstado(Estado estado, Long id) {
        Pedido pedido = getById(id);
        pedido.setEstado(estado);
        return create(pedido);
    }
}

