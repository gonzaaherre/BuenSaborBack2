package com.entidades.buenSabor.domain.enums;

public enum Estado {
    PENDIENTE,//El pedido realizado por el cliente ingresa a la bandeja de entrada de pedidos pendientes del cajero
    PREPARACION,//(cajero) revisa el pedido y si está correcto, loaprueba, cocinero consulta los pedidos aprobados que debe prepara
    TERMINADO,//cuando el pedido está listo lomarca con estado terminado
    FACTURADO,// con la forma de pago que corresponda y será entregada al cliente, dejando el pedido con el estado final FACTURADO
    CANCELADO,
    RECHAZADO,
    ENTREGADO,
    DELIVERY
}
