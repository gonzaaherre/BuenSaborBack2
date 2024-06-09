package com.entidades.buenSabor.domain.dto.Insumo;

import com.entidades.buenSabor.domain.dto.BaseDto;
import com.entidades.buenSabor.domain.dto.Imagen.ImagenDto;
import com.entidades.buenSabor.domain.dto.UnidadMedida.UnidadMedidaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumoDto extends BaseDto {
    private String denominacion;
    private Double precioVenta;
    private UnidadMedidaDto unidadMedida;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;
    private Boolean esParaElaborar;
    private Boolean habilitado;
    private String categoriaNombre;
    private Set<ImagenDto> imagenes;
    private Long idSucursal;
}
