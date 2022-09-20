package com.comercio.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    public Producto(String nombre, Integer stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "stock", nullable = false)
    private Integer stock;

}
