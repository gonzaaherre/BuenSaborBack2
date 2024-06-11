package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.facade.Imp.FacturaFacadeImpl;
import com.entidades.buenSabor.business.service.Imp.FacturaServiceImp;
import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Factura.FacturaCreateDto;
import com.entidades.buenSabor.domain.dto.Factura.FacturaDto;
import com.entidades.buenSabor.domain.entities.Factura;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.entidades.buenSabor.presentation.rest.Base.BaseControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

    @RestController
    @RequestMapping("/facturas")
    @CrossOrigin("*")
public class FacturaController extends BaseControllerImp<Factura, FacturaDto, FacturaCreateDto,FacturaCreateDto, Long, FacturaFacadeImpl> {

    public FacturaController(FacturaFacadeImpl facade) {
        super(facade);
    }

    @Autowired
    private FacturaServiceImp facturaService;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/factura/{pedidoId}")
    public ResponseEntity<byte[]> descargarFactura(@PathVariable Long pedidoId) throws IOException {
        Pedido pedido = pedidoService.getById(pedidoId);
        byte[] pdfContent = facturaService.generarFacturaPDF(pedido);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "factura_" + pedidoId + ".pdf");
        headers.setContentLength(pdfContent.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfContent);
    }
}
