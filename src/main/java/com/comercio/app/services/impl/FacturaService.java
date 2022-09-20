package com.comercio.app.services.impl;

import com.comercio.app.entities.Factura;
import com.comercio.app.repositories.IBaseRepository;
import com.comercio.app.repositories.impl.FacturaRepository;
import com.comercio.app.services.IBaseService;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class FacturaService implements IBaseService<Factura> {
    private EntityManager em;
    private IBaseRepository<Factura> facturaRepository;

    public FacturaService(EntityManager em) {
        this.em = em;
        this.facturaRepository = new FacturaRepository(this.em);
    }

    @Override
    public List<Factura> findAll() {

        try {
            return this.facturaRepository.findAll();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Factura findById(Integer id) {

        try {
            if (verify(id)) {
                return this.facturaRepository.findById(id);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Factura insert(Factura factura) {

        try {
            this.em.getTransaction().begin();
            this.facturaRepository.insert(factura);
            this.em.getTransaction().commit();

            return factura;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    @Override
    public Factura update(Integer id, Factura factura) {

        try {
            if (verify(id)) {
                this.em.getTransaction().begin();
                this.facturaRepository.update(factura);
                this.em.getTransaction().commit();
                return factura;
            } else {
                return null;
            }
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }


    @Override
    public boolean delete(Integer id) {

        try {
            if (verify(id)) {
                Factura factura = findById(id);
                this.em.getTransaction().begin();
                this.facturaRepository.delete(factura);
                this.em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Error(e.getMessage());
        }

    }

    public Boolean verify(Integer id) {
        Optional<Factura> facturaVerificada = Optional.ofNullable(this.em.find(Factura.class, id));
        return facturaVerificada.isPresent();
    }
}
