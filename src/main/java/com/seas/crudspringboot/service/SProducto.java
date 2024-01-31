package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IProducto;
import com.seas.crudspringboot.model.Producto;
import com.seas.crudspringboot.repository.RProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SProducto implements IProducto {

    @Autowired
    private RProducto repository;

    @Override
    public List<Producto> getProdctos() {
        return repository.findAll();
    }

    @Override
    public Producto getProdctoId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addProducto(Producto producto) {
        repository.save(producto);

    }

    @Override
    public void deleteProdcto(Long id) {
        repository.deleteById(id);
    }
}
