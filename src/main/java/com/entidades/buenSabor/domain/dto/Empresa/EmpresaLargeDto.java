package com.entidades.buenSabor.domain.dto.Empresa;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.Sucursal.ShortSucursal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaLargeDto extends BaseDto {
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private Set<ShortSucursal> sucursales;
}
