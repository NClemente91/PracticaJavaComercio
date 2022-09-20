package com.comercio.app;

import com.comercio.app.configurations.JpaUtilDB;
import com.comercio.app.controllers.ClienteController;
import com.comercio.app.entities.Cliente;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) throws Exception {
        EntityManager em = JpaUtilDB.getEntityManager();

        ClienteController clienteController = new ClienteController(em);

        Cliente cliente = new Cliente("Martina","Lopez", "345645888", "martilopez@gmail.com");
        Cliente cliente2 = new Cliente("Lara","Juarez", "341111118", "laraJ@gmail.com");

        clienteController.createCliente(cliente);
        clienteController.createCliente(cliente2);

        cliente2.setNombre("Marcos");
        clienteController.updateCliente(cliente2.getId(),cliente2);

        //----------------
        System.out.println(clienteController.deleteCliente(2));

        System.out.println(clienteController.getClientes());



        em.close();


    }
}
