package com.comercio.app.controllers;

import com.comercio.app.entities.Direccion;
import com.comercio.app.services.IBaseService;
import com.comercio.app.services.impl.DireccionService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DireccionController {
    private EntityManager em;
    private IBaseService<Direccion> direccionService;

    public DireccionController(EntityManager em) {
        this.em = em;
        this.direccionService = new DireccionService(this.em);
    }

    public List<Direccion> getDirecciones() throws Exception {
        return direccionService.findAll();
    }

    public Direccion getDireccionById(Integer id){
        return direccionService.findById(id);
    }

    public Direccion createDireccion(Direccion direccion)  {
        return direccionService.insert(direccion);
    }

    public Direccion updateDireccion(Integer id, Direccion direccion) {
        return direccionService.update(id, direccion);
    }

    public boolean deleteDireccion(Integer id){
        return  direccionService.delete(id);
    }
}
