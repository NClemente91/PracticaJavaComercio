package com.comercio.app;

import com.comercio.app.configurations.JpaUtilDB;
import com.comercio.app.controllers.*;
import com.comercio.app.entities.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDB.getEntityManager();

        ClienteController clienteController = new ClienteController(em);
        DireccionController direccionController = new DireccionController(em);
        FacturaController facturaController = new FacturaController(em);
        PedidoController pedidoController = new PedidoController(em);
        ProductoController productoController = new ProductoController(em);

        try {

            Direccion direccion1 = new Direccion("Belgrano", 2300, "Córdoba");

            Cliente cliente1 = new Cliente("Nico", "Clemente", "343413434", "email@example.com",direccion1);

            Pedido pedido1 = new Pedido(true);
            Pedido pedido2 = new Pedido(false);

            Factura factura1 = new Factura(true, LocalDate.now());
            Factura factura2 = new Factura(true, LocalDate.now());

            Producto producto1 = new Producto("Cerveza", 100);
            Producto producto2 = new Producto("Gaseosa", 200);
            Producto producto3 = new Producto("Vodka", 150);
            Producto producto4 = new Producto("Vino", 250);

            pedido1.setFactura(factura1);
            pedido2.setFactura(factura2);

            pedido1.getProductos().add(producto1);
            pedido1.getProductos().add(producto2);
            pedido2.getProductos().add(producto3);
            pedido2.getProductos().add(producto4);

            pedido1.setCliente(cliente1);
            pedido2.setCliente(cliente1);

            pedidoController.createPedido(pedido1);
            pedidoController.createPedido(pedido2);

            producto2.setStock(999);

            productoController.updateProducto(producto2.getId(), producto2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}
