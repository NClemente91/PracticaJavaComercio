package com.comercio.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 20)
    private String apellido;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "email", nullable = false, length = 40)
    private String email;
}
