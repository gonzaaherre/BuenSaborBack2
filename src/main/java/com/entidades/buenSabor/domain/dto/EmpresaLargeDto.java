package com.entidades.buenSabor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaLargeDto extends BaseDto{
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<ShortSucursal> sucursales;
}
