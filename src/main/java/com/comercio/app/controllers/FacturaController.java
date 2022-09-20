package com.comercio.app.controllers;

import com.comercio.app.entities.Factura;
import com.comercio.app.services.IBaseService;
import com.comercio.app.services.impl.FacturaService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FacturaController {
    private EntityManager em;
    private IBaseService<Factura> facturaService;

    public FacturaController(EntityManager em) {
        this.em = em;
        this.facturaService = new FacturaService(this.em);
    }

    public List<Factura> getFacturas() throws Exception {
        return facturaService.findAll();
    }

    public Factura getFacturaById(Integer id){
        return facturaService.findById(id);
    }

    public Factura createFactura(Factura factura)  {
        return facturaService.insert(factura);
    }

    public Factura updateFactura(Integer id, Factura factura) {
        return facturaService.update(id, factura);
    }

    public boolean deleteFactura(Integer id){
        return  facturaService.delete(id);
    }
}
