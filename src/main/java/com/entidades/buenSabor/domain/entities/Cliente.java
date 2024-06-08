package com.entidades.buenSabor.domain.entities;

import com.entidades.buenSabor.domain.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class Cliente extends Base{

    protected String nombre;
    protected String apellido;
    protected String telefono;
    @Column(name = "email", unique = true)
    protected String email;

    @OneToOne
    protected Usuario usuario;

    private Rol rol = Rol.CLIENTE;

    private LocalDate fechaNacimiento;

    @OneToOne
    @NotAudited
    protected ImagenCliente imagenCliente;

    @ManyToMany
    //SE AGREGA EL JOIN TABLE PARA QUE JPA CREE LA TABLA INTERMEDIA EN UNA RELACION MANY TO MANY
    @JoinTable(name = "cliente_domicilio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    protected Set<Domicilio> domicilios = new HashSet<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}
