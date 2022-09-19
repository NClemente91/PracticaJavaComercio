package com.comercio.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "calle", nullable = false, length = 30)
    private String calle;

    @Column(name = "numero", nullable = false, length = 30)
    private Integer numero;

    @Column(name = "localidad", nullable = false, length = 30)
    private String localidad;
}
