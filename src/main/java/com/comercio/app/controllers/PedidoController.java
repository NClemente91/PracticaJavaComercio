package com.comercio.app.controllers;

import com.comercio.app.entities.Pedido;
import com.comercio.app.services.IBaseService;
import com.comercio.app.services.impl.PedidoService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PedidoController {
    private EntityManager em;
    private IBaseService<Pedido> pedidoService;

    public PedidoController(EntityManager em) {
        this.em = em;
        this.pedidoService = new PedidoService(this.em);
    }

    public List<Pedido> getPedidos() throws Exception {
        return pedidoService.findAll();
    }

    public Pedido getPedidoById(Integer id){
        return pedidoService.findById(id);
    }

    public Pedido createPedido(Pedido pedido)  {
        return pedidoService.insert(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido) {
        return pedidoService.update(id, pedido);
    }

    public boolean deletePedido(Integer id){
        return  pedidoService.delete(id);
    }
}
