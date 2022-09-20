package com.comercio.app;

import com.comercio.app.configurations.JpaUtilDB;
import com.comercio.app.controllers.*;
import com.comercio.app.entities.Cliente;
import com.comercio.app.entities.Direccion;
import jakarta.persistence.EntityManager;

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
            Cliente cliente = new Cliente("Martina", "Lopez", "345645888", "martilopez@gmail.com");
            Cliente cliente2 = new Cliente("Lara", "Juarez", "341111118", "laraJ@gmail.com");

            //Insert//
            clienteController.createCliente(cliente);
            clienteController.createCliente(cliente2);

            //Update//
            cliente2.setNombre("Marcos");
            clienteController.updateCliente(cliente2.getId(), cliente2);

            //delete//
            System.out.println(clienteController.deleteCliente(2));

            //GetAll//
            System.out.println(clienteController.getClientes());

            //GetOneById//
            System.out.println(clienteController.getClienteById(1));


            //----------DIRECCIONES----------//
            Direccion direccion1 = new Direccion("Belgrano", 2300, "Córdoba");
            Direccion direccion2 = new Direccion("San Martín", 1800, "Paraná");

            //Insert//
            direccionController.createDireccion(direccion1);
            direccionController.createDireccion(direccion2);

            //Update//
            direccion2.setLocalidad("Santa Fe");
            direccionController.updateDireccion(2, direccion2);

            //delete//
            System.out.println(direccionController.deleteDireccion(2));

            //GetAll//
            System.out.println(direccionController.getDirecciones());

            //GetOneById//
            System.out.println(direccionController.getDireccionById(2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}
