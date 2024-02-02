package com.seas.crudspringboot.service;

import com.seas.crudspringboot.interfaces.ICliente;
import com.seas.crudspringboot.model.Cliente;
import com.seas.crudspringboot.repository.RCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCliente implements ICliente {

    @Autowired
    private RCliente repository;

    @Override
    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente getClienteId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addCliente(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }
}
