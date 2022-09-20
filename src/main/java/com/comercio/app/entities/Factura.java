package com.comercio.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    public Factura(Boolean pagado, LocalDate fechaEmision) {
        this.pagado = pagado;
        this.fechaEmision = fechaEmision;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer id;

    @Column(name = "pagado")
    private Boolean pagado;

    @Column(name = "fecha_emision")
    private LocalDate fechaEmision;

}
