package com.comercio.app.services.impl;

import com.comercio.app.entities.Pedido;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.repositories.impl.PedidoRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class PedidoService implements IBaseService<Pedido> {
    private EntityManager em;
    private IBaseRepository<Pedido> pedidoRepository;

    public PedidoService(EntityManager em) {
        this.em = em;
        this.pedidoRepository = new PedidoRepository(this.em);
    }

    @Override
    public List<Pedido> findAll() {

        try{
            return this.pedidoRepository.findAll();
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Pedido findById(Integer id) {

        try{
            if(verify(id)){
                return this.pedidoRepository.findById(id);
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Pedido insert(Pedido pedido) {

        try{
            this.em.getTransaction().begin();
            this.pedidoRepository.insert(pedido);
            this.em.getTransaction().commit();

            return pedido;
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Pedido update(Integer id, Pedido pedido) {

        try{
            if(verify(id)) {
                this.em.getTransaction().begin();
                this.pedidoRepository.update(pedido);
                this.em.getTransaction().commit();
                return pedido;
            }else{
                return null;
            }
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }


    @Override
    public boolean delete(Integer id) {

        try{
            if(verify(id)){
                Pedido pedido = findById(id);
                this.em.getTransaction().begin();
                this.pedidoRepository.delete(pedido);
                this.em.getTransaction().commit();
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    public Boolean verify(Integer id){
        Optional<Pedido> pedidoVerificado = Optional.ofNullable(this.em.find(Pedido.class,id));
        return pedidoVerificado.isPresent();
    }

}
