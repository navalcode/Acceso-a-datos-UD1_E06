package com.salesianos.triana.ejercicio1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Builder.Default
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos = new ArrayList<>();

    //mappedBy no funciona, no hay entidad con la que enfrentarla.
    //Seguramente hay una solución mejor.
    @OneToMany(fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "subcategoria", foreignKey = @ForeignKey(name = "FK_CATEGORIA_SUBCATEGORIA"))
    private List<Categoria> subcategorias = new ArrayList<>();

    //HELPERS CATEGORIA-SUBCATEGORIA
    public void addSubcategoriaToCategoria(Categoria c) {
        if (subcategorias.contains(c)) {
            System.out.println("La subcategoría que intenta insertar ya existe en esta categoría.");
        } else {
            subcategorias
                    .add(c);
        }
    }

    public void removeSubcategoriaFromCategoria(Categoria c) {
        if (!subcategorias.contains(c)) {
            System.out.println("La subcategoría que intenta borrar no existe en esta categoría.");
        } else {
            subcategorias.remove(c);
        }
    }

}
