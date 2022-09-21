package com.comercio.app;

import com.comercio.app.configurations.JpaUtilDB;
import com.comercio.app.controllers.*;
import com.comercio.app.entities.*;
import jakarta.persistence.EntityManager;
import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDB.getEntityManager();

        ClienteController clienteController = new ClienteController(em);
        DireccionController direccionController = new DireccionController(em);
        FacturaController facturaController = new FacturaController(em);
        PedidoController pedidoController = new PedidoController(em);
        ProductoController productoController = new ProductoController(em);

        try {
            //----------CLIENTES----------//
//            Cliente cliente = new Cliente("Martina", "Lopez", "345645888", "martilopez@gmail.com");
//            Cliente cliente2 = new Cliente("Lara", "Juarez", "341111118", "laraJ@gmail.com");
//
//            //Insert//
//            clienteController.createCliente(cliente);
//            clienteController.createCliente(cliente2);
//
//            //Update//
//            cliente2.setNombre("Marcos");
//            clienteController.updateCliente(cliente2.getId(), cliente2);
//
//            //delete//
//            System.out.println(clienteController.deleteCliente(2));
//
//            //GetAll//
//            System.out.println(clienteController.getClientes());
//
//            //GetOneById//
//            System.out.println(clienteController.getClienteById(1));


            //----------DIRECCIONES----------//
//            Direccion direccion1 = new Direccion("Belgrano", 2300, "Córdoba");
//            Direccion direccion2 = new Direccion("San Martín", 1800, "Paraná");
//
//            //Insert//
//            direccionController.createDireccion(direccion1);
//            direccionController.createDireccion(direccion2);
//
//            //Update//
//            direccion2.setLocalidad("Santa Fe");
//            direccionController.updateDireccion(2, direccion2);
//
//            //delete//
//            System.out.println(direccionController.deleteDireccion(2));
//
//            //GetAll//
//            System.out.println(direccionController.getDirecciones());
//
//            //GetOneById//
//            System.out.println(direccionController.getDireccionById(2));

            //--------------------//
            Cliente cliente1 = new Cliente("Nico", "Clemente", "343413434", "email@example.com");

            Direccion direccion1 = new Direccion("Belgrano", 2300, "Córdoba");

            Pedido pedido1 = new Pedido(true);
            Pedido pedido2 = new Pedido(false);

            Factura factura1 = new Factura(true, LocalDate.now());
            Factura factura2 = new Factura(true, LocalDate.now());

            Producto producto1 = new Producto("Cerveza", 100);
            Producto producto2 = new Producto("Gaseosa", 200);
            Producto producto3 = new Producto("Agua", 150);
            Producto producto4 = new Producto("Vino", 250);

            pedido1.setFactura(factura1);
            pedido2.setFactura(factura2);
            pedido1.setDireccion(direccion1);
            pedido2.setDireccion(direccion1);
            pedido1.getProductos().add(producto1);
            pedido1.getProductos().add(producto2);
            pedido2.getProductos().add(producto3);
            pedido2.getProductos().add(producto4);

            direccion1.getListaPedidos().add(pedido1);
            direccion1.getListaPedidos().add(pedido2);

            cliente1.getPedidos().add(pedido1);
            cliente1.getPedidos().add(pedido2);

            clienteController.createCliente(cliente1);

            System.out.println(direccionController.getDireccionById(1).getListaPedidos());

//            //---------------Sin persistir direccion---------------//
//            pedido1.setDireccion(direccion1);
//            pedido2.setDireccion(direccion1);
//
//            pedidoController.createPedido(pedido1);
//            pedidoController.createPedido(pedido2);
//
//            pedidoController.deletePedido(1);
//            pedidoController.deletePedido(2);
//
//            System.out.println(direccionController.deleteDireccion(1));
//
//            //---------------Sin persistir pedidos---------------//
//            direccionController.createDireccion(direccion1);
//
//            direccion1.getListaPedidos().add(pedido1);
//            direccion1.getListaPedidos().add(pedido2);
//
//            direccionController.updateDireccion(1, direccion1);
//
//            System.out.println(pedidoController.getPedidos());
//
//            System.out.println(direccionController.getDireccionById(1).getListaPedidos());

            //Update//
//            direccion1.setCalle("San Martin");
//            direccionController.updateDireccion(1,direccion1);
//
//            System.out.println(pedidoController.getPedidos());

//            //delete//
//            System.out.println(direccionController.deleteDireccion(2));
//
//            //GetAll//
//            System.out.println(direccionController.getDirecciones());
//
//            //GetOneById//
//            System.out.println(direccionController.getDireccionById(2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}
