package com.comercio.app.services.impl;

import com.comercio.app.entities.Cliente;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.repositories.impl.ClienteRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteService implements IBaseService<Cliente> {

    private EntityManager em;
    private IBaseRepository<Cliente> clienteRepository;

    public ClienteService(EntityManager em) {
        this.em = em;
        this.clienteRepository = new ClienteRepository(this.em);
    }

    @Override
    public List<Cliente> findAll() {
        try{
            return this.clienteRepository.findAll();
        }catch(Exception e){
           throw new Error(e.getMessage());
        }
    }

    @Override
    public Cliente findById(Integer id) {
        try{
            if(verify(id)){
                return this.clienteRepository.findById(id);
            }else{
                return null;
            }

        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Cliente insert(Cliente cliente) {
        try{

            this.em.getTransaction().begin();
            this.clienteRepository.insert(cliente);
            this.em.getTransaction().commit();

            return cliente;

        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {

        try{
            if(verify(id)) {
                this.em.getTransaction().begin();
                this.clienteRepository.update(cliente);
                this.em.getTransaction().commit();
                return cliente;
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
                    Cliente cliente = findById(id);
                    this.em.getTransaction().begin();
                    this.clienteRepository.delete(cliente);
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

        Optional<Cliente> clienteVerificado = Optional.ofNullable(this.em.find(Cliente.class,id));

        return clienteVerificado.isPresent();
    }


}
