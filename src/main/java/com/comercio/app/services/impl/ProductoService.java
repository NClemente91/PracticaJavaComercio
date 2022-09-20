package com.comercio.app.services.impl;

import com.comercio.app.entities.Producto;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.repositories.impl.ProductoRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ProductoService implements IBaseService<Producto> {

    private EntityManager em;
    private IBaseRepository<Producto> productoRepository;

    public ProductoService(EntityManager em) {
        this.em = em;
        this.productoRepository = new ProductoRepository(this.em);
    }

    @Override
    public List<Producto> findAll() {

        try{
            return this.productoRepository.findAll();
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Producto findById(Integer id) {

        try{
            if(verify(id)){
                return this.productoRepository.findById(id);
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Producto insert(Producto producto) {

        try{
            this.em.getTransaction().begin();
            this.productoRepository.insert(producto);
            this.em.getTransaction().commit();

            return producto;
        }catch(Exception e){
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Producto update(Integer id, Producto producto) {

        try{
            if(verify(id)) {
                this.em.getTransaction().begin();
                this.productoRepository.update(producto);
                this.em.getTransaction().commit();
                return producto;
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
                Producto producto = findById(id);
                this.em.getTransaction().begin();
                this.productoRepository.delete(producto);
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
        Optional<Producto> productoVerificado = Optional.ofNullable(this.em.find(Producto.class,id));
        return productoVerificado.isPresent();
    }

}
