package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IFactura;
import com.seas.crudspringboot.model.Factura;
import com.seas.crudspringboot.repository.RFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SFactura implements IFactura {

    @Autowired
    private RFactura repository;

    @Override
    public List<Factura> getFacturas() {
        return repository.findAll();
    }

    @Override
    public Factura getFacturaId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addFactura(Factura factura) {
        repository.save(factura);
    }

    @Override
    public void deleteFactura(Long id) {
        repository.deleteById(id);
    }
}
