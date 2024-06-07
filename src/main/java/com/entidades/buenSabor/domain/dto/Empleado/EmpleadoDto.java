package com.entidades.buenSabor.domain.dto.Empleado;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Sucursal.ShortSucursal;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalShortShort;
import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto extends BaseDto {
    private String apellido;
    private String telefono;
    private String email;
    private Rol tipoEmpleado;
    private SucursalShortShort sucursal;
}
