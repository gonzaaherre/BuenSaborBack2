package com.entidades.buenSabor.domain.dto;

import java.util.Set;

public class EmpresaLargeDto extends BaseDto{
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<SucursalDto> sucursales;
}
