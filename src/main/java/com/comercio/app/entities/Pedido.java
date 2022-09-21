package com.comercio.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Direccion direccion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_pedidos_productos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", entregado= " + entregado +
                ", direccion= " +  direccion.getCalle() +
                '}';
    }
}
