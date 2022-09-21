package com.comercio.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "direcciones")
public class Direccion {
    public Direccion(String calle, Integer numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

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

    @OneToMany(orphanRemoval = true, mappedBy = "direccion")
    private List<Pedido> listaPedidos = new ArrayList<>();

}
