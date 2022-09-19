package com.comercio.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "stock", nullable = false)
    private Integer stock;

}
