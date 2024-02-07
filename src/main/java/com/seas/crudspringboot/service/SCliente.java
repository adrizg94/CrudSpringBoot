package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.IServicio;
import com.seas.crudspringboot.model.Cliente;
import com.seas.crudspringboot.repository.RCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCliente implements IServicio<Cliente, Long> {

    @Autowired
    private RCliente repository;

    @Override
    public List<Cliente> get() {
        return repository.findAll();
    }

    @Override
    public Cliente getId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
