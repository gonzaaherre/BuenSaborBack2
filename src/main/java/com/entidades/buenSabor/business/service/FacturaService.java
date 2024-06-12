package com.entidades.buenSabor.business.service;

import com.entidades.buenSabor.business.service.Base.BaseService;
import com.entidades.buenSabor.domain.entities.Factura;
import com.entidades.buenSabor.domain.entities.Pedido;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;


public interface FacturaService extends BaseService<Factura, Long> {
    byte[] generarFacturaPDF(Pedido pedido) throws IOException;
}
