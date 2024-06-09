package com.entidades.buenSabor.domain.dto.Empleado;

import com.entidades.buenSabor.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoCreateDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private Rol tipoEmpleado;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private Long idSucursal;
}
