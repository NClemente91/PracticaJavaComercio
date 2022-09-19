package com.comercio.app.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer id;

    @Column(name = "pagado")
    private Boolean pagado;

    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

}
