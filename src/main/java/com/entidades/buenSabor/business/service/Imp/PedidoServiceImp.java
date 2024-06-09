package com.entidades.buenSabor.business.service.Imp;

import com.entidades.buenSabor.business.mapper.PedidoMapper;
import com.entidades.buenSabor.business.service.ArticuloInsumoService;
import com.entidades.buenSabor.business.service.ArticuloService;
import com.entidades.buenSabor.business.service.Base.BaseServiceImp;
import com.entidades.buenSabor.business.service.EmpleadoService;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.entities.*;
import com.entidades.buenSabor.domain.enums.Estado;
import com.entidades.buenSabor.domain.enums.Rol;
import com.entidades.buenSabor.domain.enums.TipoEnvio;
import com.entidades.buenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
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


}






//    @Override
//    public Pedido save(PedidoCreateDto pedidoCreateDto) {
//        if (pedidoCreateDto.getDetallePedidos() == null || pedidoCreateDto.getDetallePedidos().isEmpty()) {
//            throw new IllegalArgumentException("Un pedido debe tener al menos un detalle de pedido.");
//        }
//        Pedido pedido = pedidoMapper.toEntityCreate(pedidoCreateDto);
//        Pedido savedPedido = pedidoRepository.save(pedido);
//
//        // Decrementar el stock de los artículos insumos
//        if (pedido.getEstado() == Estado.ENTREGADO) {
//            actualizarStockArticulos(savedPedido.getId());
//        }
//
//        return savedPedido;


//    @Override
//    public Pedido update(PedidoCreateDto pedidoCreateDto, Long id) {
//        if (pedidoCreateDto.getDetallePedidos() == null || pedidoCreateDto.getDetallePedidos().isEmpty()) {
//            throw new IllegalArgumentException("Un pedido debe tener al menos un detalle de pedido.");
//        }
//        var pedidoDB = pedidoRepository.findById(id);
//        if (pedidoDB.isEmpty()) {
//            throw new RuntimeException("No se encontró una entidad con el id " + id);
//        }
//        Pedido pedido = pedidoMapper.toEntityCreate(pedidoCreateDto);
//        pedido.setId(id);
//        return pedidoRepository.save(pedido);
//    }

//    @Override
//    public void actualizarStockArticulos(Long pedidoId) {
//        Pedido pedido = pedidoRepository.findById(pedidoId)
//                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
//        for (DetallePedido detalle : pedido.getDetallePedidos()) {
//            if (detalle.getArticulo() instanceof ArticuloInsumo) {
//                articuloInsumoService.decrementStock(detalle.getArticulo().getId(), detalle.getCantidad());
//            }
//        }
//    }
