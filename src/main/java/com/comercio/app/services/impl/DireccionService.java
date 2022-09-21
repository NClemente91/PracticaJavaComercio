package com.comercio.app.services.impl;

import com.comercio.app.entities.Direccion;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.repositories.impl.DireccionRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class DireccionService implements IBaseService<Direccion> {
    private EntityManager em;
    private IBaseRepository<Direccion> direccionRepository;

    public DireccionService(EntityManager em) {
        this.em = em;
        this.direccionRepository = new DireccionRepository(this.em);
    }

    @Override
    public List<Direccion> findAll() {

        try{
            return this.direccionRepository.findAll();
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Direccion findById(Integer id) {

        try{
            if(verify(id)){
                return this.direccionRepository.findById(id);
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Direccion insert(Direccion direccion) {

        try{
            this.em.getTransaction().begin();
            this.direccionRepository.insert(direccion);
            this.em.getTransaction().commit();

            return direccion;
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Direccion update(Integer id, Direccion direccion) {

        try{
            if(verify(id)) {
                this.em.getTransaction().begin();
                this.direccionRepository.update(direccion);
                this.em.getTransaction().commit();
                return direccion;
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
                Direccion direccion = findById(id);
                System.out.println(direccion);
                this.em.getTransaction().begin();
                this.direccionRepository.delete(direccion);
                this.em.getTransaction().commit();
                Direccion direccion1 = findById(id);
                System.out.println(direccion1);
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
        Optional<Direccion> direccionVerificada = Optional.ofNullable(this.em.find(Direccion.class,id));
        return direccionVerificada.isPresent();
    }

}
