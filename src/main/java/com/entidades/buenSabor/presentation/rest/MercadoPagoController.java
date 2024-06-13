package com.entidades.buenSabor.presentation.rest;

import com.entidades.buenSabor.business.service.PedidoService;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoCreateDto;
import com.entidades.buenSabor.domain.dto.Pedido.PedidoMPDto;
import com.entidades.buenSabor.domain.entities.MpPreference;
import com.entidades.buenSabor.domain.entities.Pedido;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiMp")
@CrossOrigin("*")
public class MercadoPagoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/{idPedido}")
    public MpPreference getList(@PathVariable Long idPedido) {

        /*
        *  List<PreferenceItemRequest> items = new ArrayList<>();
        for (PedidoDetalleDto detalle : pedido.getPedidosDetalle()) {
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(detalle.getTitle())
                    .quantity(detalle.getQuantity())
                    .unitPrice(new BigDecimal(detalle.getUnitPrice()))
                    .build();
            items.add(itemRequest);
        }
        *
        * */
        Pedido pedido = pedidoService.getById(idPedido);


        try {
            MercadoPagoConfig.setAccessToken("TEST-2798566161607489-052311-a8e97e298823f472ca61f8c492cbb871-322089866");

            //Creamos la preferencia
            //PREFERENCIA DE VENTA
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id(String.valueOf(pedido.getId()))
                    .title("pedido realizado")
                    .description("Pedido realizado desde el carrito de compras")
                    .pictureUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwIO85PD8j6F_gTdPtZC20xoE6MOVD0dcR_Q&s")
                    .quantity(1)
                    .currencyId("ARG")
                    .unitPrice(new BigDecimal(pedido.getTotal()))
                    .build();
            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            //preferencia de control de sucesos en el caso que toque lo redirecciona a otra pagna
            //aca no pueden ir url localesm, pero hacemos una excepcion
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("http://localhost:5173")
                    .pending("http://localhost:5173")
                    .failure("http://localhost:5173")
                    .build();

            //preferencia que tendra todas las preferencias que se hayan creado
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrls)
                    .build();

            // creo un cliente para comunicarme con mp
            PreferenceClient client = new PreferenceClient();
            //se crea una nueeva prefertencia que es igual a lla respuesta
            Preference preference = client.create(preferenceRequest);


            MpPreference mpPreference = new MpPreference();
            mpPreference.setStatusCode(preference.getResponse().getStatusCode());
            mpPreference.setId(preference.getId());
            return mpPreference;


        } catch (MPException e) {
            throw new RuntimeException(e.getMessage());

        } catch (MPApiException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
