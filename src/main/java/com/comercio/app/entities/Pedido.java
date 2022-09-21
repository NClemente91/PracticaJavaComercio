package com.comercio.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    public Pedido(Boolean entregado) {
        this.entregado = entregado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entregado")
    private Boolean entregado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Direccion direccion;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", entregado= " + entregado +
                ", direccion= " +  direccion.getCalle() +
                '}';
    }
}
