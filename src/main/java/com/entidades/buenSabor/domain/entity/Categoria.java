package com.entidades.buenSabor.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Categoria extends Base{

    private String denominacion;

    @OneToMany
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

}
