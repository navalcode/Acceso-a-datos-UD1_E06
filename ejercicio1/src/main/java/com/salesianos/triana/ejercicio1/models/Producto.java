package com.salesianos.triana.ejercicio1.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Producto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;

    public void addCategoria(Categoria c) {
        this.categoria = c;
        c.getProductos().add(this);
    }

    public void removeCategoria(Categoria c) {
        c.getProductos().remove(this);
        this.categoria = null;
    }

    public Producto(String nombre, double pvp) {
        this.nombre = nombre;
        this.pvp = pvp;
    }
}
