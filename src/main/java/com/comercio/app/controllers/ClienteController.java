package com.comercio.app.controllers;

import com.comercio.app.entities.Cliente;
import com.comercio.app.services.IBaseService;
import com.comercio.app.services.impl.ClienteService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteController {
    private EntityManager em;
    private IBaseService<Cliente> clienteService;

    public ClienteController(EntityManager em) {
        this.em = em;
        this.clienteService = new ClienteService(this.em);
    }

    public List<Cliente> getClientes() throws Exception {
        return clienteService.findAll();
    }

    public Cliente getClienteById(Integer id){
        return clienteService.findById(id);
    }

    public Cliente createCliente(Cliente cliente)  {
        return clienteService.insert(cliente);
    }

    public Cliente updateCliente(Integer id, Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    public boolean deleteCliente(Integer id){
        return  clienteService.delete(id);
    }

}
