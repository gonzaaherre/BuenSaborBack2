package com.entidades.buenSabor.domain.dto.Empleado;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Sucursal.ShortSucursal;
import com.entidades.buenSabor.domain.dto.Sucursal.SucursalShortShort;
import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Rol rol;
    private SucursalShortShort sucursal;

}
