package com.entidades.buenSabor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    private Set<Categoria> subCategorias = new HashSet<>();}
